<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script language="javascript" src="http://code.jquery.com/jquery-2.0.0.min.js"></script>
        <script language="javascript">
       

    /*     function pageLoad() {
            var startButton = document.getElementById("start"); */

          //  startButton.onclick = setInterval(alertMe,2000);
          
     /*    } */
     
     
			
	
       var myVar = setInterval(load_ajax, 1000);
            function load_ajax(){
                $.ajax({
                    url : "dangkypms",
                    type : "get",
                     dataType:"text",
                     data : {
                         number : $('#number').val()
                    }, 
                   success : function (hello1){
                        $('#hello').html(hello1);
                    }
                });


                
            }
    
        </script>

<!-- <script type="text/javascript">

	$(document).ready(function(){
		$('#hello').click(function(){
			/* var fullnames =  $('#fullname').val(); */
			$.ajax({
				type:'POST',
			/* 	data: {fullname: fullnames}, */
				url:'Trong',
				success: function(result){
					$('#result1').html(result)
				}
			})
		})
	})
</script>  -->

</head>
<body>
<div class="container" >
<jsp:include page="Header.jsp" />
		<jsp:include page="menu.jsp" />
<span id="hello"></span>
<!-- Name <input type="text" id="fullname"> -->
<!-- <a href="#" id="hello" > -->
<!-- asda</a>

<input type="button" name="clickme" id="start" onclick="pageLoad()" value="Click Me"/> -->

<!-- <!-- <span id="result1"></span> --> 
<jsp:include page="footer.jsp" />
	</div>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>
