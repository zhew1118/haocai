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
                        <table class="table table-bordered table-hover table-condensed">
                            <thead>
                            <tr>
                                <th>
                                    耗材编号
                                </th>
                                <th>
                                    耗材名称
                                </th>
                                <th>
                                    购买时间
                                </th>
                                <th>
                                    有效期
                                </th>
                                <th>
                                    规格
                                </th>
                                <th>
                                    供应商
                                </th>
                                <th>
                                    种类
                                </th>
                                <th>
                                    库存数量
                                </th>
                                <th>
                                    单位
                                </th>
                                <th>
                                    上架
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                    <#list haocaiPage.content as haocai>
                    <tr>
                        <td>
                            ${haocai.haocaiId}
                        </td>
                        <td>
                            ${haocai.haocaiName}
                        </td>
                        <td>
                            ${haocai.haocaiPurchaseDate}
                        </td>
                        <td>
                            ${haocai.haocaiExpirationDate}
                        </td>
                        <td>
                            ${haocai.haocaiSpec}
                        </td>
                        <td>
                            ${haocai.haocaiVendor}
                        </td>
                        <td>
                            ${haocai.haocaiType}
                        </td>
                        <td>
                            ${haocai.haocaiAmount}
                        </td>
                        <td>
                            ${haocai.haocaiUnit}
                        </td>
                        <td>
                            ${haocai.haocaiStatus}
                        </td>
                    </tr>
                    </#list>
                            </tbody>
                        </table>
                    </div>

                    <#--分页-->
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                            <#if currentPage lte 1>
                                <li class="disabled">
                                    <a href="#">上一页</a>
                                </li>
                            <#else>
                                <li>
                                    <a href="/admin/list?page=${currentPage-1}&size=${size}">上一页</a>
                                </li>
                            </#if>

                            <#list 1..haocaiPage.getTotalPages() as index>
                                <#if currentPage == index>
                                    <li class="disabled"><a href="/admin/list?page=${index}&size=${size}">${index}</a></li>
                                <#else>
                                    <li>
                                        <a href="/admin/list?page=${index}&size=${size}">${index}</a>
                                    </li>
                                </#if>
                            </#list>
                            <#if currentPage gte haocaiPage.getTotalPages()>
                                <li class="disabled">
                                    <a href="#">下一页</a>
                                </li>
                            <#else>
                                <li class="disabled">
                                    <a href="/admin/list?page=${currentPage+1}&size=${size}">下一页</a>
                                </li>
                            </#if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>