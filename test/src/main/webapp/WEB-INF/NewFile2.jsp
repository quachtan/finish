<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script language="javascript" src="http://code.jquery.com/jquery-2.0.0.min.js"></script>
        <script language="javascript">
       

        function pageLoad() {
            var startButton = document.getElementById("start");

          //  startButton.onclick = setInterval(alertMe,2000);
            startButton.onclick = setInterval(load_ajax, 3000);
        }
     
     
			
	
      
            function load_ajax(){
                $.ajax({
                    url : "dangkypms",
                    type : "get",
                   /*  dataType:"text", */
                   /*  data : {
                         number : $('#number').val()
                    }, */
                   success : function (abc){
                        $('#hello').html(abc);
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
<form>
Name <input type="text" id="fullname">
<a href="#" id="hello" >
asda</a>
<input type="button" name="clickme" id="start" onclick="pageLoad()" value="Click Me"/>
<br>
<!-- <!-- <span id="result1"></span> --> -->
</form>
</body>
</html>
