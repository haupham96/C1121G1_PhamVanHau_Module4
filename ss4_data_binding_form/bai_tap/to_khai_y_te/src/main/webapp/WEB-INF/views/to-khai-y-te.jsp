<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 31/03/2022
  Time: 11:38 SA
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tờ Khai Y Tế</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <%--    <link rel="stylesheet" href="boostrap/css/bootstrap.min.css">--%>
</head>
<body>
<div class="container text-center">
    <div class="row">
        <h1>Tờ Khai Y Tế</h1>
        <h3>THÔNG TIN CỦA BẠN ... PHÒNG CHỐNG DỊCH BỆNH</h3>
        <h5 style="color: red">Khuyến cáo : khai báo sai = vi phạm PL</h5>
    </div>
</div>

<form:form method="post" modelAttribute="toKhaiYTe">
    <div class="container">
        <div class="row">
            <div class="form-group">
                <label for="exampleFormControlInput1">Họ Tên</label><span class="text-danger">(*)</span>
                <form:input path="hoTen" type="text" class="form-control" id="exampleFormControlInput1"/>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-4">
                <label for="exampleFormControlInput2">Năm Sinh</label><span class="text-danger">(*)</span>
                <form:input path="namSinh" type="text" class="form-control" id="exampleFormControlInput2"/>
            </div>
            <div class="form-group col-4">
                <label for="exampleFormControlInput3">Giới tính</label><span class="text-danger">(*)</span>
                <form:select items="${gioiTinh}" path="gioiTinh" type="text" class="form-control"
                             id="exampleFormControlInput3"/>
            </div>
            <div class="form-group col-4">
                <label for="exampleFormControlInput4">Quôc tịch</label><span class="text-danger">(*)</span>
                <form:select path="quocTich" items="${quocTich}" type="text" class="form-control"
                             id="exampleFormControlInput4"/>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <label for="exampleFormControlInput5">CMND</label><span class="text-danger">(*)</span>
                <form:input path="CMND" type="text" class="form-control" id="exampleFormControlInput5"/>
            </div>
        </div>
        <div class="row">
            <label>Thông tin đi lại</label><span class="text-danger">(*)</span>
            <span> <form:radiobuttons path="tenPhuongTien" items="${phuongTien}"/>&nbsp </span>
        </div>
        <div class="row">
            <div class="form-group col-6">
                <label for="exampleFormControlInput6">Số hiệu phương tiện</label>
                <form:input path="soHieuPhuongTien" class="form-control" id="exampleFormControlInput6"/>
            </div>
            <div class="form-group col-6">
                <label for="exampleFormControlInput7">Số ghế</label>
                <form:input path="soGhe" class="form-control"
                            id="exampleFormControlInput7"/>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-6">
                <label for="exampleFormControlInput8">Ngày khởi hành</label>
                <form:input type="date" path="ngayKhoiHanh" class="form-control" id="exampleFormControlInput8"/>
            </div>
            <div class="form-group col-6">
                <label for="exampleFormControlInput9">Ngày kết thúc</label>
                <form:input type="date" path="ngayKetThuc" class="form-control" id="exampleFormControlInput9"/>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-12">
                <label for="exampleFormControlInput10">14 ngày qua đã đi đâu ?</label><span
                    class="text-danger">(*)</span>
                <form:textarea path="thongTinDiChuyen14Ngay" class="form-control" id="exampleFormControlInput10"/>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <p><b>Địa chỉ liên lạc</b></p>
        </div>
        <div class="row">
            <div class="form-group col-4">
                <label for="exampleFormControlInput11">Tỉnh / Thành</label><span class="text-danger">(*)</span>
                <form:select items="${tinhThanh}" path="tinhThanh" type="text" class="form-control"
                             id="exampleFormControlInput11"/>
            </div>
            <div class="form-group col-4">
                <label for="exampleFormControlInput12">Quận / Huyện</label><span class="text-danger">(*)</span>
                <form:select items="${quanHuyen}" path="quanHuyen" type="text" class="form-control"
                             id="exampleFormControlInput12"/>
            </div>
            <div class="form-group col-4">
                <label for="exampleFormControlInput13">Phường / Xã</label><span class="text-danger">(*)</span>
                <form:select items="${phuongXa}" path="phuongXa" type="text" class="form-control"
                             id="exampleFormControlInput13"/>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-12">
                <label for="exampleFormControlInput14">Địa chỉ nơi ở :</label>
                <form:input type="text" path="soNha" class="form-control" id="exampleFormControlInput14"/>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-6">
                <label for="exampleFormControlInput15">Điện thoại :</label>
                <form:input type="text" path="dienThoai" class="form-control" id="exampleFormControlInput15"/>
            </div>
            <div class="form-group col-6">
                <label for="exampleFormControlInput16">Email :</label>
                <form:input type="text" path="email" class="form-control" id="exampleFormControlInput16"/>
            </div>
        </div>
        <div class="row">
            <p><b>các triệu chứng trong 14 ngày gần đây :</b></p>
        </div>
        <div class="row">
            <div class="col-6">
                <table border="1">
                    <thead>
                    <tr>
                        <th>Triệu chứng</th>
                        <th>có</th>
                        <th>không</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Sốt</td>
                        <td><form:radiobutton path="sot" value="1"/></td>
                        <td><form:radiobutton path="sot" value="0"/></td>
                    </tr>
                    <tr>
                        <td>Ho</td>
                        <td><form:radiobutton path="ho" value="1"/></td>
                        <td><form:radiobutton path="ho" value="0"/></td>
                    </tr>
                    <tr>
                        <td>Khó thở</td>
                        <td><form:radiobutton path="khoTho" value="1"/></td>
                        <td><form:radiobutton path="khoTho" value="0"/></td>
                    </tr>
                    <tr>
                        <td>Đau họng</td>
                        <td><form:radiobutton path="dauHong" value="1"/></td>
                        <td><form:radiobutton path="dauHong" value="0"/></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="col-6">
                <table border="1">
                    <thead>
                    <tr>
                        <th>Triệu chứng</th>
                        <th>có</th>
                        <th>không</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Nôn</td>
                        <td><form:radiobutton path="buonNon" value="1"/></td>
                        <td><form:radiobutton path="buonNon" value="0"/></td>
                    </tr>
                    <tr>
                        <td>Tiêu Chảy</td>
                        <td><form:radiobutton path="tieuChay" value="1"/></td>
                        <td><form:radiobutton path="tieuChay" value="0"/></td>
                    </tr>
                    <tr>
                        <td>Xuất huyết</td>
                        <td><form:radiobutton path="xuatHuyet" value="1"/></td>
                        <td><form:radiobutton path="xuatHuyet" value="0"/></td>
                    </tr>
                    <tr>
                        <td>Nổi ban</td>
                        <td><form:radiobutton path="noiBan" value="1"/></td>
                        <td><form:radiobutton path="noiBan" value="0"/></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-6">

            </div>
            <div class="col-6 ">
                <button class="btn btn-success mx-auto" type="submit">Gửi</button>
            </div>

        </div>
    </div>
</form:form>
<p class="text-danger">${mess}</p>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>

</html>
