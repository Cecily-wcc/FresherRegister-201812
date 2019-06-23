<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
  	<!-- 此处action要与controller中对应的requestmapping解析url一致（括号中参数） 表单默认用post方法传递 controller设置接受方法为RequestMethod.POST -->
    <form action="login" method="post">
    	<!-- 关联变量 从底层至高层 po>dao>service>controller中 uid pwd要与此处一致 
    	但从controller到dao过程中由user对象传 所以只考虑controller层与此参数一致 -->
    	用户<input type="text" name="uid"/>
    	密码<input type="text" name="pwd"/>
    	<input type="submit" values="登录"/>
    </form>
  </body>
</html>
