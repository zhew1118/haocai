<html>
<head>
    <meta charset="utf-8">
    <title>德清友好医院库存管理系统</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../../static/css/style.css">
</head>
<body>
<div id="wrapper" class="toggled">

<#--边栏-->
    <#include "../common/nav.ftl">

<#--主要内容-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/admin/save">
                        <div class="form-group">
                            <label>耗材名称</label>
                            <input name="haocaiName" type="text" class="form-control" value="${(haocai.haocaiName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>购买时间</label>
                            <input name="haocaiPurchaseDate" type="text" class="form-control" value="${(haocai.haocaiPurchaseDate)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>有效期</label>
                            <input name="haocaiExpirationDate" type="text" class="form-control" value="${(haocai.haocaiExpirationDate)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>规格</label>
                            <input name="haocaiSpec" type="text" class="form-control" value="${(haocai.haocaiSpec)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>供应商</label>
                            <input name="haocaiVendor" type="text" class="form-control" value="${(haocai.haocaiVendor)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>种类</label>
                            <input name="haocaiType" type="text" class="form-control" value="${(haocai.haocaiType)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>库存数量</label>
                            <input name="haocaiAmount" type="text" class="form-control" value="${(haocai.haocaiAmount)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>单位</label>
                            <input name="haocaiUnit" type="text" class="form-control" value="${(haocai.haocaiUnit)!''}"/>
                        </div>
                        <input hidden type="text" name="haocaiId" value="${(haocai.haocaiId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>