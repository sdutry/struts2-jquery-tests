<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html lang="en">
  <head>
    <sj:head compressed="true"/>
  </head>
  <body>
    <div id="result" class="result ui-widget-content ui-corner-all">Click on the link bellow.</div>
    <s:url var="ajax" namespace="/" action="ajax-simple-text"/>
    <sj:a id="ajaxlink" href="%{ajax}" targets="result" indicator="indicator" button="true" buttonIcon="ui-icon-refresh">
      Run AJAX action
    </sj:a>
  </body>
</html>
