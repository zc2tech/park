<?php ?>
<!DOCTYPE html>
<html>
<head>
<title>访客信息错误</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/scripts/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1>访客信息错误</h1>

<div class="row">
  <div class="col-sm-3">电话</div>
  <div class="col-sm-9"><?php echo $tel ?></div>
</div>

<h3><a href="<?php echo site_url("guest_door/index") ?>" >回到菜单</a></h3>
</div>
</body>
</html>