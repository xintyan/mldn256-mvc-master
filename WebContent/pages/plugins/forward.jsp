<%@ page pageEncoding="UTF-8" %>
<script type="text/javascript">
	window.onload = function() {
		goForward() ;
	}
	function goForward() {
		spanObject = document.getElementById("countSpan") ;
		count = parseInt(spanObject.innerHTML) ;	// 取得当前计数的内容
		count -- ;
		if (count == 0) {	// 要进行跳转
			window.location = "${url}" ;	// 跳转
		} else {
			spanObject.innerHTML = count ;
			setTimeout(goForward,1000) ; 
		}
	}
</script>
<div>${msg}</div> 
<div><span id="countSpan">20</span>秒后跳转到其它页面！</div>