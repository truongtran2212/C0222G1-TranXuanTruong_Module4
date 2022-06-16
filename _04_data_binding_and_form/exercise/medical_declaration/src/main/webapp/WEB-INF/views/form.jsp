<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 6/16/2022
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/datatables/css/dataTables.bootstrap4.min.css">


</head>
<body>
<h2 style="text-align: center">TỜ KHAI Y TẾ</h2>
<h4 style="text-align: center">
    ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH
    BỆNH TRUYỀN NHIỄM
</h4>
<h5 style="color: red; text-align: center">
    Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự
</h5>
<form:form modelAttribute="medical" action="/information" method="post">
    <div class="container-fluid">

        <div>
            <label>Họ tên (ghi chữ in hoa)</label>
            <br>
            <form:input path="name" cssStyle="width: 100%"></form:input>
        </div>

        <div style="display: flex ; align-items: center; justify-content: space-between">
            <div style="width: 33%">
                <label>Năm sinh</label>
                <form:select path="dateOfBirth">
                    <form:options items="${year}" class="w-100"></form:options>
                </form:select>
            </div>
            <div style="width: 33%">
                <label>Giới tính</label>
                <form:select path="gender">
                    <form:options items="${gender}"></form:options>
                </form:select>

            </div>
            <div style="width: 33%">
                <label>Quốc tịch</label>
                <form:select path="nationality">
                    <form:options items="${nationality}"></form:options>
                </form:select>
            </div>
        </div>

        <div>
            <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</label>
            <br>
            <form:input path="idCard" cssStyle="width: 100%"></form:input>
        </div>

        <div>
            <label>Thông tin đi lại</label>
            <br>
            <form:radiobutton path="travelInformation" value="Tàu bay" cssStyle="margin-left: 20px"></form:radiobutton>
            Tàu bay

            <form:radiobutton path="travelInformation" value="Tàu thuyền"
                              cssStyle="margin-left: 20px"></form:radiobutton>Tàu thuyền

            <form:radiobutton path="travelInformation" value="Ô tô" cssStyle="margin-left: 20px"></form:radiobutton>Ô tô

            <form:radiobutton path="travelInformation" value="Khác" cssStyle="margin-left: 20px"></form:radiobutton>Khác
        </div>

        <div style="display: flex ; align-items: center; justify-content: space-between">
            <div class="col-md-6">
                <label>Số hiệu phương tiện</label>
                <br>
                <form:input path="vehicleNumber"></form:input>
            </div>

            <div class="col-md-6">
                <label>Số ghế</label>
                <br>
                <form:input path="seats"></form:input>
            </div>
        </div>

        <div style="display: flex ; align-items: center; justify-content: space-between">
            <div class="col-md-6">
                <label>Ngày khởi hành</label>
                <br>
                <form:input type="date" path="startDay"></form:input>
            </div>

            <div class="col-md-6">
                <label>Ngày kết thúc</label>
                <br>
                <form:input type="date" path="endDay"></form:input>
            </div>
        </div>

        <div>
            <label>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?</label>
            <br>
            <form:input path="city" cssStyle="width: 100%"></form:input>
        </div>
    </div>
    <button type="submit" style="text-align: center">Khai báo</button>
</form:form>
</body>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap4.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="/bootstrap413/js/bootstrap.bundle.min.js"></script>
</html>
