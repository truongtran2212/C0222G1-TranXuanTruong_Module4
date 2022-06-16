<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/16/2022
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Tên: ${medical.name}</h3>

<h3>Năm sinh: ${medical.dateOfBirth}</h3>

<h3>Giới tính: ${medical.gender}</h3>

<h3>Quốc tịch: ${medical.nationality}</h3>

<h3>CMND: ${medical.idCard}</h3>

<h3>Thông tin đi lại: ${medical.travelInformation}</h3>

<h3>Số hiệu phương tiện: ${medical.vehicleNumber}</h3>

<h3>Số ghế: ${medical.seats}</h3>

<h3>Ngày bắt đầu: ${medical.startDay}</h3>

<h3>Ngày kết thúc: ${medical.endDay}</h3>

<h3>Thành phố đã đến:${medical.city} </h3>

</body>
</html>
