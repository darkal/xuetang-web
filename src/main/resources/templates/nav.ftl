<#assign base=springMacroRequestContext.getRequestUri()/>
<nav class="menu">
    <ul class="sidebar-menu metismenu" id="sidebar-menu">
        <li>
            <a href="index.html">
                <i class="fa fa-home"></i> 矿冶学堂管理后台 </a>
        </li>
        <li class="${(base?contains("content.do") || base?contains("list.do"))?string("active open","")}">
            <a href="">
                <i class="fa fa-th-large"></i> 资源管理
                <i class="fa arrow"></i>
            </a>
            <ul class="sidebar-nav">
                <li class="${base?contains("list.do")?string("active","")}">
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
        <li>
            <a href="">
                <i class="fa fa-table"></i> Tables
                <i class="fa arrow"></i>
            </a>
            <ul class="sidebar-nav">
                <li>
                    <a href="static-tables.html"> Static Tables </a>
                </li>
                <li>
                    <a href="responsive-tables.html"> Responsive Tables </a>
                </li>
            </ul>
        </li>
        <li>
            <a href="forms.html">
                <i class="fa fa-pencil-square-o"></i> Forms </a>
        </li>
        <li>
            <a href="">
                <i class="fa fa-desktop"></i> UI Elements
                <i class="fa arrow"></i>
            </a>
            <ul class="sidebar-nav">
                <li>
                    <a href="buttons.html"> Buttons </a>
                </li>
                <li>
                    <a href="cards.html"> Cards </a>
                </li>
                <li>
                    <a href="typography.html"> Typography </a>
                </li>
                <li>
                    <a href="icons.html"> Icons </a>
                </li>
                <li>
                    <a href="grid.html"> Grid </a>
                </li>
            </ul>
        </li>
        <li>
            <a href="">
                <i class="fa fa-file-text-o"></i> Pages
                <i class="fa arrow"></i>
            </a>
            <ul class="sidebar-nav">
                <li>
                    <a href="login.html"> Login </a>
                </li>
                <li>
                    <a href="signup.html"> Sign Up </a>
                </li>
                <li>
                    <a href="reset.html"> Reset </a>
                </li>
                <li>
                    <a href="error-404.html"> Error 404 App </a>
                </li>
                <li>
                    <a href="error-404-alt.html"> Error 404 Global </a>
                </li>
                <li>
                    <a href="error-500.html"> Error 500 App </a>
                </li>
                <li>
                    <a href="error-500-alt.html"> Error 500 Global </a>
                </li>
            </ul>
        </li>
        <li>
            <a href="">
                <i class="fa fa-sitemap"></i> Menu Levels
                <i class="fa arrow"></i>
            </a>
            <ul class="sidebar-nav">
                <li>
                    <a href="#"> Second Level Item
                        <i class="fa arrow"></i>
                    </a>
                    <ul class="sidebar-nav">
                        <li>
                            <a href="#"> Third Level Item </a>
                        </li>
                        <li>
                            <a href="#"> Third Level Item </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"> Second Level Item </a>
                </li>
                <li>
                    <a href="#"> Second Level Item
                        <i class="fa arrow"></i>
                    </a>
                    <ul class="sidebar-nav">
                        <li>
                            <a href="#"> Third Level Item </a>
                        </li>
                        <li>
                            <a href="#"> Third Level Item </a>
                        </li>
                        <li>
                            <a href="#"> Third Level Item
                                <i class="fa arrow"></i>
                            </a>
                            <ul class="sidebar-nav">
                                <li>
                                    <a href="#"> Fourth Level Item </a>
                                </li>
                                <li>
                                    <a href="#"> Fourth Level Item </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
        <li>
            <a href="https://github.com/modularcode/modular-admin-html">
                <i class="fa fa-github-alt"></i> Theme Docs </a>
        </li>
    </ul>
</nav>