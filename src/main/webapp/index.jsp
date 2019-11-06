<%--
  Created by IntelliJ IDEA.
  User: lilij667
  Date: 2019/11/5
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Netty WebSocket 时间服务器</title>

    <script type="text/javascript">
        var socket;
        if (!window.WebSocket) {

            window.WebSocket=window.MozWebSocket;
        }

        if (window.WebSocket){
           socket = new WebSocket("ws://localhost:8081/websocket");
            socket.onmessage=function (ev) {
                var ta =document.getElementById('responseText');
                ta.value ="";
                ta.value = ev.data;
            };

            socket.onopen=function (ev) {
                var ta =document.getElementById('responseText');
                ta.value= "打开websocket服务正常,游览器支持websocket!";


            };

            socket.onclose=function (ev) {
                var ta = document.getElementById('responseText');
                ta.value="";
                ta.value = "websocket关闭";
            }

        }else {
            alert("抱歉,您的游览器不支持websocket协议");
        }

        function send(message) {
            if (!window.WebSocket){return;}
            if (socket.readyState == WebSocket.OPEN){
                socket.send(message);
            }else {
                alert("webSocket 连接没有建立成功")
            }
        }



    </script>

</head>
<body>

<form onsubmit="false">
    <input type="text" name="message" value="Netty最佳时间"/>
    <br>
    <input type="button" value="发送消息" onclick="send(this.form.message.value)"/>
    <hr color="blue">
    <h3>服务端返回的应答消息</h3>
    <textarea id="responseText" style="width: 500px;height: 300px"></textarea>
</form>

</body>
</html>
