# cotogenineInvoke
这是我在学习spring时的一个想法,
如果能像spring的bean注入一样，能够将调用的接口通过配置文件进行注入，那么就能使逻辑代码和接口调用解耦。
通过修改配置文件中的配置来实现相同的逻辑调用不同的接口。

比如http接口配置

<invoke id=””>
	<protocol name=””></protocol>
		<url></url>
		<method></method>
		<params>
		<param>
			<paramIndex></paramIndex>
			<paramName></paramName>
			<paramType></paramType>
			<paramValue></paramValue>
<param>
<param>
	<paramIndex></paramIndex>
			<paramName></paramName>
			<paramType></paramType>
			<paramValue></paramValue>
<param>
</params>
<returnValues>
		<returnValue>
			<name></name>
			<type></type>
			<value></value>
</returnValue>
</returnValues>
</protocol>
</invoke>

每个invoke对应一个BaseInvoke类的对象，该类是个抽象类， 聚合xmlparse对象负责解析xml文件，提供基本的传入参数的方法。
HttpInvoke， 根据传入的参数和解析的配置文件，组装http接口，并等待消息返回（同步），
是否要支持异步接口，后续再说。
通过httpclient，建立并配置
BaseXmlParse类
解析xml的基础类该类是个抽象类，根据protocol的name分配解析类

httpXmlParse类
解析httpxml的配置维护两个map， 一个inputmap，一个retmap，
Inputmap以paramIndex为key
