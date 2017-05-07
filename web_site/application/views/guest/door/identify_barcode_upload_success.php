<?php ?>
<!DOCTYPE html>
<html>
<head>
<title>上传二维码成功</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/scripts/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1>上传二维码成功</h1>

<div class="row h3">
  <div class="col-sm-3">访客电话号码</div>
  <div class="col-sm-9"><a href="<?php echo site_url("guest_door/guest_info/" . $tel) ?>" ><?php echo $tel ?></a> </div>
</div>


<h3><a href="<?php echo site_url("guest_door/index") ?>" >回到菜单</a></h3>
</div>
</body>
</html>