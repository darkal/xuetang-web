<#assign base=springMacroRequestContext.getRequestUri()/>
<nav class="menu">
    <ul class="sidebar-menu metismenu" id="sidebar-menu">
        <li>
            <a href="index.html">
                <i class="fa fa-home"></i> 矿冶学堂管理后台 </a>
        </li>
        <li class="${(base?contains("cate"))?string("active open","")}">
            <a href="">
                <i class="fa fa-th-large"></i> 分类管理
                <i class="fa arrow"></i>
            </a>
            <ul class="sidebar-nav">
                <li class="${base?contains("catelist.do")?string("active","")}">
                    <a href="catelist.do"> 分类列表 </a>
                </li>
                <li class="${base?contains("cate.do")?string("active","")}">
                    <a href="cate.do"> 新建分类 </a>
                </li>
            </ul>
        </li>
        <li class="${(base?contains("content.do") || base?contains("/list.do"))?string("active open","")}">
            <a href="">
                <i class="fa fa-th-large"></i> 资源管理
                <i class="fa arrow"></i>
            </a>
            <ul class="sidebar-nav">
                <li class="${base?contains("/list.do")?string("active","")}">
                    <a href="list.do"> 资源列表 </a>
                </li>
                <li class="${base?contains("content.do")?string("active","")}">
                    <a href="content.do"> 新建资源 </a>
                </li>
            </ul>
        </li>
        <li class="${base?contains("comment.do")?string("active open","")}">
            <a href="">
                <i class="fa fa-bar-chart"></i> 评论管理
                <i class="fa arrow"></i>
            </a>
            <ul class="sidebar-nav">
                <li class="${base?contains("comment.do")?string("active","")}">
                    <a href="comment.do"> 评论列表 </a>
                </li>
                <li>
                    <a href="charts-morris.html"> Morris Charts </a>
                </li>
            </ul>
        </li>
    </ul>
</nav>