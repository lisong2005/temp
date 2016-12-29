
<#ftl output_format="HTML">
<#import "/spring.ftl" as spring />
<#-- 注释 -->
<html>
<head>
  <title>Welcome !</title>
</head>
<body>
  <h1>Welcome ${user}!</h1>
  <h1>Welcome ${userxx!"visitor"}!</h1>
  <#if userss??><h1>Welcome ${user}!</h1></#if>
  <p>Our latest product: xxx</p>
  <p>
  <a href="${latestProductUrl}">${latestProductName}</a>!
</body>
</html>