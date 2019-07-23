<html>
<#--head-->
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--sidebar-->
    <#include "../common/nav.ftl">
    <#--content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-hover table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>商品ID</th>
                            <th>名称</th>
                            <th>图片</th>
                            <th>单价</th>
                            <th>库存</th>
                            <th>描述</th>
                            <th>类目</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                <#list list.content as productInfo>
                <tr>
                    <td>${productInfo.productId}</td>
                    <td>${productInfo.productName}</td>
                    <td><img height="100" width="100" src="${productInfo.productIcon}" alt=""></td>
                    <td>${productInfo.productPrice}</td>
                    <td>${productInfo.productStock}</td>
                    <td>${productInfo.productDescription}</td>
                    <td>${productInfo.categoryType}</td>
                    <td>${productInfo.createTime}</td>
                    <td>${productInfo.updateTime}</td>
                    <td><a href="/sell/seller/product/index?productId=${productInfo.productId}">修改</a></td>
                    <#if productInfo.getProductStatusEnum().code == 0>
                        <td><a href="/sell/seller/product/off_sale?productId=${productInfo.productId}">下架</a></td>
                    <#else>
                        <td><a href="/sell/seller/product/on_sale?productId=${productInfo.productId}">上架</a></td>
                    </#if>
                </tr>
                </#list>
                        </tbody>
                    </table>

                </div>
            <#--分页-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                <#if currentPage lte 1>
                    <li class="disabled"><a href="#">Prev</a></li>
                <#else>
                    <li><a href="/sell/seller/product/list?page=${currentPage - 1}&size=${currentSize}">Prev</a></li>
                </#if>
                <#list 1..list.getTotalPages() as index>
                    <#if currentPage == index >
                        <li class="disabled"><a href="#">${index}</a></li>
                    <#else>
                    <li><a href="/sell/seller/product/list?page=${index}&size=${currentSize}">${index}</a></li>
                    </#if>
                </#list>
                <#if currentPage gte list.getTotalPages()>
                    <li class="disabled"><a href="#">Next</a></li>
                <#else>
                    <li><a href="/sell/seller/product/list?page=${currentPage + 1}&size=${currentSize}">Next</a></li>
                </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>