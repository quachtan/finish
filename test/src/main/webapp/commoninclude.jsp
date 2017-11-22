<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


 <c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />

<link rel="shortcut icon" href="//api.jquery.com/jquery-wp-content/themes/api.jquery.com/i/favicon.ico">
<link href="<c:url value="/resources/js/libs/jquery-ui.css" />" rel="stylesheet">
<link href="<c:url value="/resources/js/libs/jquery-ui.theme.css" />" rel="stylesheet">
<link type="text/css" href="<c:url value="/resources/js/libs/bootstrap-3.3.5/css/bootstrap.css" />" rel="stylesheet" />
<link type="text/css" href="<c:url value="/resources/css/common.css" />" rel="stylesheet" />
<link type="text/css" href="<c:url value="/resources/js/libs/fancyBox-v2.1.5-0/source/jquery.fancybox.css" />" rel="stylesheet" />
 
<script src="<c:url value="/resources/js/libs/jquery-1.11.3.js" />"></script>
<script src="<c:url value="/resources/js/libs/jquery-ui.js" />"></script>
<script type="text/javascript">
	// Change JQueryUI plugin names to fix name collision with Bootstrap.
	$.widget.bridge('uitooltip', $.ui.tooltip);
	$.widget.bridge('uibutton', $.ui.button);
</script>
<script src="<c:url value="/resources/js/libs/jquery.price_format.2.0.js" />"></script>
<script src="<c:url value="/resources/js/libs/localization.js" />"></script>
<script src="<c:url value="/resources/js/libs/qrcodejs/qrcode.js" />"></script>
<script src="<c:url value="/resources/js/libs/jsviews.js" />"></script>
<script src="<c:url value="/resources/js/libs/jquery.print.full.js" />"></script>
<script src="<c:url value="/resources/js/libs/jquery.ui.datepicker-vi-VN.js" />"></script>
<script src="<c:url value="/resources/js/libs/bootstrap-3.3.5/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/template/simpliq/js/jquery-migrate-1.2.1.min.js" />"></script>
<script src="<c:url value="/resources/template/simpliq/js/modernizr.js" />"></script>
<script src="<c:url value="/resources/template/simpliq/js/jquery.cookie.js" />"></script>
<script src="<c:url value="/resources/js/libs/jquery.validate.js" />"></script>
<script src="<c:url value="/resources/js/libs/jquery.validate.additional-methods.js" />"></script>
<script src="<c:url value="/resources/js/libs/jquery.validate.messages.js" />"></script>
<script src="<c:url value="/resources/js/libs/jquery.mask.js" />"></script>
<script src="<c:url value="/resources/js/libs/fancyBox-v2.1.5-0/source/jquery.fancybox.js" />"></script>
<script src="<c:url value="/resources/js/libs/notifier.js" />"></script>
<script src="<c:url value="/resources/js/common.js" />"></script>
<script>
	CMSCommonJs.ROOT_URL = "${baseURL}/";
	CMSCommonJs.FILE_URL = "<c:url value='/file?path=' />";
</script>

<script src="<c:url value="/resources/js/form-select2.js" />"></script>
<script src="<c:url value="/resources/js/form-validate.js" />"></script>
<script src="<c:url value="/resources/js/form-datatable.js" />"></script>
<script src="<c:url value="/resources/js/viethoa.js" />"></script>
<script src="<c:url value="/resources/js/danhmuc.js" />"></script>
<script src="<c:url value="/resources/js/libs/SimpleFormTable.js" />"></script>