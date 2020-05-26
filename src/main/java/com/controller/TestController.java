package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.annotaion.Authorize;
import com.dto.ClmStatementRela;
import com.service.TestService;
import com.service.impl.Demo;
import com.service.impl.TestServiceImpl;
import com.utils.ApplicationContextUtil;
import com.utils.MyEvent;
import com.service.impl.TestAspect;
import com.websocket.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private TestAspect testAspect;

    @Autowired
    private Demo demo;

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @Authorize(outPutClass = ClmStatementRela.class)
    private ModelAndView get(HttpServletRequest request, HttpServletResponse response) {

        //HttpSession httpSession =request.getSession(true);
       /* SqlSession session = MybatisUtil.getSession();

        System.out.println(session);
        ClmStatementRelaMapper mapper = session.getMapper(ClmStatementRelaMapper.class);

       *//* List<ClmStatementRela>  clmStatementRelas5= sqlSession.selectList("com.mapper.ClmStatementRelaMapper.selectLocal",101);*//*
        List<ClmStatementRela> clmStatementRelas = mapper.selectLocal(101);

        //清除缓存后，相同的SQL会重复执行，不清除的情况下，相同的SQL只会执行一次
        session.clearCache();

        Map map = new HashMap<>();
        map.put("row",100);
        List<ClmStatementRela> clmStatementRelas4 = mapper.selectLocal2(map);
        logger.error("我错了");

        Map result =new HashMap();
        result.put("result",clmStatementRelas);*/

        ApplicationContext applicationContext = ApplicationContextUtil.getApplicationContext();
        MyEvent myEvent = new MyEvent("wo de ");
        applicationContext.publishEvent(myEvent);
        //List<ClmStatementRela> clmStatementRelas = testService.selectLocal(100);
        Map result = new HashMap();
        demo.demo2(100253L);
        //result.put("result", clmStatementRelas);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("test");
        //httpSession.setMaxInactiveInterval(15);
        return modelAndView;
    }

    @RequestMapping(value = "/getValidateCode", method = RequestMethod.GET)
    private void getValidateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServletOutputStream outputStream = response.getOutputStream();

        BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);


        Graphics2D gra = image.createGraphics();


        Font font = new Font("宋体", Font.ITALIC | Font.BOLD, 40);
        gra.setFont(font);
        gra.fillRect(0, 0, 200, 100);
        gra.setColor(Color.BLACK);
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int i1 = random.nextInt(10);
            integers.add(i1);
        }
        String str = "" + integers.get(0) + integers.get(1) + integers.get(2) + integers.get(3);
        gra.drawString(str, 0, 50);
        ImageIO.write(image, "jpg", outputStream);
        /*File file=new File("C:\\Users\\MAC\\Desktop\\f73800e5861580a4af28d6a42e29bf3.png");
        FileInputStream fis = new FileInputStream(file);
//        获取本地字节输出流
        ServletOutputStream out = response.getOutputStream();
        int len=0;
//        建立一个数组 一次读1024个字节
        byte[] bytes = new byte[256];
        int i=0;
        while ((len=fis.read(bytes))!=-1 && i<80){
            out.write(bytes,0,len);
            i++;
        }
        fis.close();*/
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Map map =new HashMap();
        HttpSession session = request.getSession(true);
        String s = (String) session.getAttribute("code");
        ModelAndView modelAndView =new ModelAndView();
       /* if (!jsonObject.get("code").equals(s)){
            modelAndView.addObject("flag",false);
            modelAndView.addObject("msg","验证按错误");
            modelAndView.setViewName("test");
        }else {

        }*/
        session.setMaxInactiveInterval(20);
        modelAndView.setViewName("hello");
       return modelAndView;
    }

    @RequestMapping(value = "/getImage", method = RequestMethod.GET)
    private void getImage(HttpServletResponse response) throws IOException {

       ServletOutputStream outputStream =response.getOutputStream();
        byte[] entity2;
        RestTemplate restTemplate=new RestTemplate();

        entity2 = restTemplate.postForObject("http://localhost:8080/getValidateCode" , null, byte[].class);


        String filename = java.net.URLEncoder.encode("影像信息", "UTF-8");
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline;filename*=utf-8'zh_cn'" + filename + ".pdf");
        outputStream = response.getOutputStream();
        outputStream.write(entity2);
        outputStream.flush();


        WebSocket ws = new WebSocket();
        JSONObject jo = new JSONObject();
        jo.put("message", "这个比密码不对还想登录!");
        jo.put("To", "admin");// 给用户名为admin的用户推送
        try {
            ws.onMessage(jo.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
