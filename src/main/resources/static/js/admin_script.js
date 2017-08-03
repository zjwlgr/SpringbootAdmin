$(function(){

    $loadimg = '<img src="/public/image/loaders/1.gif" />';
    $csrf = $("meta[name='csrf-token']").attr('content');
    String.prototype.trim=function() {
        return this.replace(/(^\s*)|(\s*$)/g,'');
    }

    /*管理员登录验证*/
    $("#form1_login").bind("submit", function(){
        var  $username = $("#username"),$password = $("#password"),$validates = $("#validates");
        if($username.val() == ""){
            art.dialog({lock: true,opacity: 0.5,content: "用户名不能为空！",icon: 'warning',ok: function(){$username.focus();}});
            return false;
        }
        if($password.val() == ""){
            art.dialog({lock: true,opacity: 0.5,content: "密码不能为空！",icon: 'warning',ok: function(){$password.focus();}});
            return false;
        }
        if($validates.val() == ""){
            art.dialog({lock: true,opacity: 0.5,content: "验证码不能为空！",icon: 'warning',ok: function(){$validates.focus();}});
            return false;
        }
        $("#loading").button('loading');
        $.post("/admin/login/index.html",$("#form1_login").serialize(),function(data){
            if(data.code == 0){
                art.dialog({lock: true,opacity: 0.5,content: data.msg,icon: 'error',ok: function(){}});
                $(".image").click();
                $("#loading").button('reset');
            }else{
                window.location.href = data.msg;
            }
        },'json');
        return false
    });

    /*左侧收缩效果*/
    if($(".sidebar-menu").length > 0){
        var $ulsub = $(".sidebar-menu > ul > li:first-child");
        $ulsub.addClass('open').children('.sub').slideDown(0);
        $ulsub.children('a').children('.arrow').removeClass('glyphicon-triangle-left').addClass('glyphicon-triangle-bottom');
    }//第一个默认展开，纯属多余 暂时保留
    $(document).delegate('a.offsite','click', function(){
        var $hasid = $(this).attr('id');
        var $sub = $(this).next();
        var $glyphicon = $(this).children('.arrow');
        if($sub.is(":visible")){
            $(this).parent().removeClass('open');
            $glyphicon.removeClass('glyphicon-triangle-bottom').addClass('glyphicon-triangle-left');
            $sub.slideUp(200);
        }else{
            /*展开当前块，关闭已展开块*/
            $(".has-sub > ul.sub:visible").parent().removeClass('open');
            $(".has-sub > ul.sub:visible").parent().children('a').children('.arrow').removeClass('glyphicon-triangle-bottom').addClass('glyphicon-triangle-left');
            $(".has-sub > ul.sub:visible").slideUp(200);
            /*展开当前点击的功能组*/
            $(this).parent().addClass('open');
            $glyphicon.removeClass('glyphicon-triangle-left').addClass('glyphicon-triangle-bottom');
            $sub.slideDown(200);
        }
    });//点击展开收起

    /*左侧点击选中状态 && 展开当前功能所在组*/
    if($(".has-sub").length > 0){
        var $pathname = window.location.pathname;
        var $pathname_ar = $pathname.split('/');
        $(".has-sub > .sub >li a").each(function(){
            var $href = $(this).attr('href');//获取href
            var $htre_ar = $href.split('/');//拆分为数组
            if($pathname_ar[2] == $htre_ar[2] && $htre_ar[2] != undefined){
                $(this).addClass('cur');//选中对应功能列
                /*展开当前块，关闭已展开块*/
                $(".has-sub > ul.sub:visible").parent().removeClass('open');
                $(".has-sub > ul.sub:visible").parent().children('a').children('.arrow').removeClass('glyphicon-triangle-bottom').addClass('glyphicon-triangle-left');
                $(".has-sub > ul.sub:visible").slideUp(0);
                /*展开对应功能所在组*/
                $(this).parent().parent().parent().addClass('open');
                $(this).parent().parent().parent().children('.arrow').removeClass('glyphicon-triangle-left').addClass('glyphicon-triangle-bottom');
                $(this).parent().parent().slideDown(0);
            }
        });
    }

    /*功能组 选择时操作*/
    $("#function_group > li > a").bind('click', function(){
        var $i = $(this).attr('_i');
        var $t = $(this).html();
        $(this).parent().parent().prev().children('#text').html($t);
        $(this).parent().parent().parent().removeClass('open');
        $("#fid").val($i);
        if($i == 0){
            $("#fidname").val('').attr('disabled',false);
        }else{
            $("#fidname").val($t).attr('disabled',true);
        }
        return false;
    });

    /*add funciton submit operation*/
    $("#form1_function").bind('submit', function(){
        if($('#fidname').val() == ''){
            art.dialog({lock: true,opacity: 0.5,content: '请选择或输入功能组名称',icon: 'warning',ok: function(){}});
            return false;
        }
        if($('#fname').val() == ''){
            art.dialog({lock: true,opacity: 0.5,content: "请输入功能名称！",icon: 'warning',ok: function(){$('#fname').focus();}});
            return false;
        }
        if($('#furi').val() == ''){
            art.dialog({lock: true,opacity: 0.5,content: "请输入功能URI！",icon: 'warning',ok: function(){$('#furi').focus();}});
            return false;
        }
    });

    /*删除操作的 confirm*/
    $(".delete").bind('click', function(){
        var $m = $(this).attr('_m');
        var $href = $(this).attr('href');

        var $d = $(this).attr('_d');
        if($d != 0 && $d != undefined){
            art.dialog({lock: true,opacity: 0.5,content: "请先删除功能组下面的功能！",icon: 'error',ok: function(){$('#furi').focus();}});
            return false;
        }//========================满足条件删除，删功组

        if($m == '' || $m == undefined){$m = '确定要删除该信息？一旦删除将不能回复！';}
        art.dialog({
            lock: true, opacity: 0.5, icon: 'question',
            content: $m,
            ok: function () {
                window.location.href = $href;
                return true;
            },
            cancelVal: '关闭',
            cancel: true //为true等价于function(){}
        });

        return false;
    });

    /*下拉菜单选择时操作*/
    $(document).delegate('#dropdownMenuone > li > a','click',function(){
    //$("#dropdownMenuone > li > a").bind('click', function(){
        var $i = $(this).attr('_i');
        var $t = $(this).html();
        $(this).parent().parent().prev().children('#text').html($t);
        $(this).parent().parent().next().val($i);
        $(this).parent().parent().parent().removeClass('open');
        return false;
    });

    /*搜索提示为空*/
    $("#form1_search").bind('submit', function(){
        if($("#search").val() == ''){
            art.dialog({lock: true,opacity: 0.5,content: "请输入要搜索的关键字！",icon: 'warning',ok: function(){$('#search').focus();}});
            return false;
        }
    });

    /*管理员录入时间显示*/
    $("[data-toggle='tooltip']").tooltip();

    /*管理员分组 权限部分 点击变为蓝色字*/
    var i = 1;
    $(".checkboxclick").bind('click', function(){
        var yu = i % 2;
        if(yu == 0) {
            var $this = $(this);
            if ($this.children('input').attr('checked')) {
                $this.children('input').attr('checked',false);
                $this.removeClass('ceboxse');
            } else {
                $this.children('input').attr('checked',true);
                $this.addClass('ceboxse');
            }
        }
        i = i + 1;
    });

    /*管理员分组 提交判断*/
    $("#form1_group").bind('submit', function(){
        if($("#gname").val() == ''){
            art.dialog({lock: true,opacity: 0.5,content: "请输入管理组名称！",icon: 'warning',ok: function(){$('#gname').focus();}});
            return false;
        }
        if($(".jquery_click[type='checkbox']").is(':checked') == false){
            art.dialog({lock: true,opacity: 0.5,content: "请选择该管理组权限！",icon: 'warning',ok: function(){}});
            return false;
        }
    });

    /*管理员新增 提交判断*/
    $("#form1_manager").bind('submit', function(){
        if($("#group_id").val() == ''){
            art.dialog({lock: true,opacity: 0.5,content: "请选择用户组！",icon: 'warning',ok: function(){}});
            return false;
        }
        if($('#username').val().length < 3 || $('#username').val().length > 18){
            art.dialog({lock: true,opacity: 0.5,content: "请输入用户名，长度范围 3 - 18 位！",icon: 'warning',ok: function(){$('#username').focus();}});
            return false;
        }
        if($('#id').length == 0){//如果新增，判断密码不能为空
            if($('#password').val() == ""){
                art.dialog({lock: true,opacity: 0.5,content: "请输入密码，长度范围 6 - 18 位！",icon: 'warning',ok: function(){$('#password').focus();}});
                return false;
            }
        }
        if($('#password').val() != "") {//如果密码不为空，判断密码长度，和重复密码
            if($('#password').val().length < 6 || $('#password').val().length > 18){
                art.dialog({lock: true,opacity: 0.5,content: "请输入密码，长度范围 6 - 18 位！",icon: 'warning',ok: function(){$('#password').focus();}});
                return false;
            }
            if($('#password').val() != $('#repassword').val()){
                art.dialog({lock: true,opacity: 0.5,content: "两次密码不一致，请重新输入！",icon: 'warning',ok: function(){$('#repassword').focus();}});
                return false;
            }
        }
        if($('#uname').val() == ''){
            art.dialog({lock: true,opacity: 0.5,content: "请输入管理员姓名！",icon: 'warning',ok: function(){$('#uname').focus();}});
            return false;
        }
    });

    /*修改密码 提交判断*/
    $("#form1_editpwd").bind('submit', function(){
        if($('#oldpassword').val() == ''){
            art.dialog({lock: true,opacity: 0.5,content: "请输入旧密码！",icon: 'warning',ok: function(){$('#oldpassword').focus();}});
            return false;
        }
        if($('#password').val().length < 6 || $('#password').val().length > 18){
            art.dialog({lock: true,opacity: 0.5,content: "请输入密码，长度范围 6 - 18 位！",icon: 'warning',ok: function(){$('#password').focus();}});
            return false;
        }
        if($('#password').val() != $('#repassword').val()){
            art.dialog({lock: true,opacity: 0.5,content: "两次密码不一致，请重新输入！",icon: 'warning',ok: function(){$('#repassword').focus();}});
            return false;
        }
    });

    /*左上侧搜索功能*/
    $("#left_search").bind('keyup', function(){
        var $val = $(this).val();
        if($("#left_hidden").val() == '') {//把左侧列表暂存一个隐藏域中
            $("#left_hidden").val($("#left_ajax").html());
        }
        if($("#left_hidden_search").val() != $val) {//如果框中值无变化 不操作
            $("#search_loader img").show();
            $("#search_loader").removeClass('glyphicon-search');
            $.post($("#left_hidden_url").val(), {search: $val, _csrf: $csrf}, function (data) {
                if($val == ''){//如果清空了搜索把左侧列表放回原处
                    $("#left_ajax").html($("#left_hidden").val());
                }else {
                    $("#left_ajax").html(data);
                }
                $("#search_loader img").hide();
                $("#search_loader").addClass('glyphicon-search');
            });
        }
        $("#left_hidden_search").val($val);
        return false;
    });

    /*无限级分类 部分 =====*/

    $(document).delegate('.add-new-cla','blur', function(){
        var $this = $(this);
        var $name = $this.val();
        var $_i = $this.attr('_i');
        var $_d = $this.attr('_d');
        if($name.trim() != '') {
            $this.prev().html($loadimg);
            $.post($("#addclass-u").val(), {fid: $_i, depth: $_d, name: $name.trim(), _csrf: $csrf}, function (data) {
                $this.parent().parent().parent().before(data);
                $this.val('');
                $this.prev().html('新增');
            });
        }
    });//添加分类

    $(document).delegate('.del-old-cla','click', function(){
        var $this = $(this);
        var $_i = $this.attr('_i');
        art.dialog({
            lock: true, opacity: 0.5, icon: 'question',
            content: '确定要删除该分类？<br /><span style="color: #ff000c">这也将会删掉该分类下的所有子类！！！</span>',
            ok: function () {
                $this.html($loadimg);
                $.post($("#delclass-u").val(), {id: $_i, _csrf: $csrf}, function (data) {
                    $this.parent().parent().remove();
                    $this.html('删除');
                });
                return true;
            },
            cancelVal: '关闭',
            cancel: true //为true等价于function(){}
        });
        return false;
    });//删除分类

    $(document).delegate('.up-old-cla','blur', function(){
        var $this = $(this);
        var $name = $this.val();
        var $_i = $this.attr('_i');
        var $_v = $this.attr('_v');
        if($name.trim() != '' && $name != $_v) {
            $.post($("#upclass-u").val(), {id: $_i, name: $name.trim(), _csrf: $csrf}, function (data) {
                if (data == 1) {$this.css({color: "#00aa00"});}
            });
        }
    });//编辑分类 - name

    $(document).delegate('.up-old-asc','blur', function(){
        var $this = $(this);
        var $name = $this.val();
        var $_i = $this.attr('_i');
        var $_v = $this.attr('_v');
        if($name.trim() != '' && $name != $_v) {
            $.post($("#upclass-u").val(), {id: $_i, sort: $name.trim(), _csrf: $csrf}, function (data) {
                if (data == 1) {$this.css({color: "#00aa00"});}
            });
        }
    });//编辑分类 - sort

    $(document).delegate('.up-down-cla','click', function(){
        var $this = $(this);
        var $_i = $this.attr('_i');
        if($this.attr('_set') == 'd'){//如果已经展开
            $("#next_" + $_i).html('');
            $this.attr('_set', 'u');
            $this.html('展开');
            $this.removeClass('text-yellow').addClass('text-blue');
        }else {
            $this.html($loadimg);
            $.post($("#updclass-u").val(), {id: $_i, _csrf: $csrf}, function (data) {
                $("#next_" + $_i).html(data);
                $this.attr('_set', 'd');
                $this.html('收起');
                $this.removeClass('text-blue').addClass('text-yellow');
                $(document).click();
            });
        }
        return false;
    });//展开和收起

    interval = 0;
    $(document).delegate('.up-down-cla','mousedown', function(e){
        if(3 == e.which){//如果右击
            var $_i = $(this).attr('_i');
            document.getElementById('rightkey_'+$_i).oncontextmenu=function(){
                return false;//只屏蔽当前按钮的右键菜单
            };
            if($(this).attr('_set') == 'u') {//右击只能作用在未展开的按钮上
                $(this).click();//展开当前类的子类
                interval = window.setInterval(function () {
                    $("#next_" + $_i + " .up-down-cla[_set=u]").click();//展开所有类的子类
                }, 1300);//需要每隔1秒检索up-down-cla并点击，一直在检索点击
            }
        }else{
            window.clearInterval(interval);//如果左击取消setInterval效果
        }
        return false;
    });//双击展开所有子分类

    $(document).delegate('.show-grid[mouse=row]','mouseenter',function(){
        $(this).css({background:'#f8f8f8'});
    }).delegate('.show-grid[mouse=row]','mouseleave',function(){
        $(this).css({background:'#ffffff'});
    });//鼠标滑过变色

    /*无限级分类 部分 =====*/

    /*文章添加 - 选择一级分类 加载二级分类*/
    $("#dropdownMenuone_article > li > a").bind('click', function(){
        var $this = $(this);
        var $i = $this.attr('_i');
        var $t = $this.html();
        $this.parent().parent().prev().children('#text').html($t);
        $this.parent().parent().next().val($i);
        $this.parent().parent().parent().removeClass('open');
        $this.parent().parent().parent().next().html($loadimg);
        $.post($("#ajax_class_two-u").val(), {id: $i, _csrf: $csrf}, function (data) {
            $this.parent().parent().parent().next().html(data);
        });
        return false;
    });

    /*新增文章的验证*/
    $("#form1_article").bind('submit', function(){
        if($("#class_one_id").val() == ''){
            art.dialog({lock: true,opacity: 0.5,content: "请选择文章一级分类！",icon: 'warning',ok: function(){}});
            return false;
        }
        if($("#class_two_id").val() == '' || $("#class_two_id").length <= 0){
            art.dialog({lock: true,opacity: 0.5,content: "请选择文章二级分类！",icon: 'warning',ok: function(){}});
            return false;
        }
        if($("#title").val() == ''){
            art.dialog({lock: true,opacity: 0.5,content: "请输入文章标题！",icon: 'warning',ok: function(){$('#title').focus();}});
            return false;
        }
        if(ue.hasContents() == false){
            art.dialog({lock: true,opacity: 0.5,content: "请输入文章详细内容！",icon: 'warning',ok: function(){ue.focus()}});
            return false;
        }
    });







});


