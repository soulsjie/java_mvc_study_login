# java_mvc_study_login
java三层结构实现用户登录业务：
	jsp表单上的button提交事件，触发web层的实现login业务的servlet中的dopost()方法
	web层（表示层）：servlet将表单数据存到数据实体类中，方便其他层使用，通过判断调用service层中的login()的方法后的返回值判断用户是否登录成功了，如果验证成功跳转至login_success.jsp否则跳转至login_err.jsp
	service层（业务逻辑层）：（登录业务--将用户输入的表单信息和数据库的信息对比--如果验证成功返回“success”否则返回null）
	dao层（数据访问层）：执行sql语句读取数据库中是否存在用户信息，如果有将用户名和密码存到数据实体类中，供service层使用
