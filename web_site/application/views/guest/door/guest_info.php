<?php ?>
<!DOCTYPE html>
<html>
<head>
<title>访客信息</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/scripts/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1>访客信息</h1>

<div class="row h3 text-left">
  <div class="col-sm-3">phone</div>
  <div class="col-sm-9"><?php echo $tuser->phone ?></div>
</div>

<div class="row h3 text-left">
  <div class="col-sm-3">mail</div>
  <div class="col-sm-9"><?php echo $tuser->mail ?></div>
</div>


<h3><a href="<?php echo site_url("guest_door/index") ?>" >车位信息</a></h3>
<h3><a href="<?php echo site_url("guest_door/index") ?>" >回到菜单</a></h3>
</div>
</body>
</html>