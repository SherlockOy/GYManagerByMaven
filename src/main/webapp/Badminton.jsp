<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>”√´«Ú≥°</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


<style type="text/css">
#apDiv1 {
	position: absolute;
	width: 40px;
	height: 21px;
	z-index: 1;
	left: 780.7px;
	top: 385.6px;
}

#apDiv2 {
	position: absolute;
	width: 47px;
	height: 28px;
	z-index: 2;
	left: 850.8px;
	top: 393.5px;
}

#apDiv3 {
	position: absolute;
	width: 170px;
	height: 30px;
	z-index: 5;
	left: 307px;
	top: 44.5px;
}

#apDiv4 {
	position: absolute;
	width: 913px;
	height: 115px;
	z-index: 4;
	left: 2px;
	top: 130px;
}

#apDiv5 {
	position: absolute;
	z-index: 3;
	left: 97px;
	top: 44.5px;
}

<
style type ="text /css"> /*<![CDATA[*/ a,label {
	display: block;
	width: 25px;
	height: 25px;
	overflow: hidden
}

a {
	background: url("images/ok.jpg") no-repeat
}

a:hover {
	background: url("images/ok.jpg") no-repeat
}

a#b {
	background: url("images/to_regist.jpg") no-repeat
}
/*]]>*/
</style>

<script type="text/javascript">
	function submit() {
		submit();
	}
	function resetBtn(fm) {
		fm.reset();
		return false;
	}
	function resetAttribute() {
		(String)
		session.setAttribute("dayofchoose", null);
	}
</script>
</head>

<body background="images/Badminton_order.jpg" bgproperties="fixed"
	text="#ffffff">
	<div id="apDiv3">
		<a href="choosedate_badminton.jsp"> <img src="images/repick.jpg" />
		</a>
	</div>

	<font face="Courier New, Courier, monospace">


		<form id="form_badminton" name="form_badminton"
			action="badminton_order.action" method="post">

			<div id="apDiv4">
				<table layout="fixed" cellSpacing="5" align="center">
					<%
						int i = 1;
					%>
					<s:iterator value="resultFields" var="rfs">
						<tr>
							<td style="width: 10px; height: 55px"><font size="5"
								color="#00a0e9"><s:property value="#rfs.fieldNum" /></font></td>
							<td style="width: 60px; height: 55px"><font color="#00a0e9"><s:property
										value="#rfs.date" /></font></td>
							<td align="center" bgColor="#00a0e9"
								style="width: 95px; height: 55px"><s:if
									test="%{#rfs.timeSec1!=0}">
					ø…‘§∂©<br>
									<input type="checkbox" name="order" value="<%=i%>a" />
								</s:if> <s:else>
									<img src="images/order_ed.jpg">
								</s:else></td>

							<td align="center" bgColor="#00a0e9"
								style="width: 95px; height: 55px"><s:if
									test="%{#rfs.timeSec2!=0}">
					ø…‘§∂©<br>
									<input type="checkbox" name="order" value="<%=i%>b" />
								</s:if> <s:else>
									<img src="images/order_ed.jpg">
								</s:else></td>

							<td align="center" bgColor="#00a0e9"
								style="width: 95px; height: 55px"><s:if
									test="%{#rfs.timeSec3!=0}">
					ø…‘§∂©<br>
									<input type="checkbox" name="order" value="<%=i%>c" />
								</s:if> <s:else>
									<img src="images/order_ed.jpg">
								</s:else></td>

							<td align="center" bgColor="#00a0e9"
								style="width: 95px; height: 55px"><s:if
									test="%{#rfs.timeSec4!=0}">
					ø…‘§∂©<br>
									<input type="checkbox" name="order" value="<%=i%>d" />
								</s:if> <s:else>
									<img src="images/order_ed.jpg">
								</s:else></td>

							<td align="center" bgColor="#00a0e9"
								style="width: 95px; height: 55px"><s:if
									test="%{#rfs.timeSec5!=0}">
					ø…‘§∂©<br>
									<input type="checkbox" name="order" value="<%=i%>e" />
								</s:if> <s:else>
									<img src="images/order_ed.jpg">
								</s:else></td>

							<td align="center" bgColor="#00a0e9"
								style="width: 95px; height: 55px"><s:if
									test="%{#rfs.timeSec6!=0}">
					ø…‘§∂©<br>
									<input type="checkbox" name="order" value="<%=i%>f" />
								</s:if> <s:else>
									<img src="images/order_ed.jpg">
								</s:else></td>

							<td align="center" bgColor="#00a0e9"
								style="width: 95px; height: 55px"><s:if
									test="%{#rfs.timeSec7!=0}">
					ø…‘§∂©<br>
									<input type="checkbox" name="order" value="<%=i%>g" />
								</s:if> <s:else>
									<img src="images/order_ed.jpg">
								</s:else></td>

							<td align="center" bgColor="#00a0e9"
								style="width: 95px; height: 55px"><s:if
									test="%{#rfs.timeSec8!=0}">
					ø…‘§∂©<br>
									<input type="checkbox" name="order" value="<%=i%>h" />
								</s:if> <s:else>
									<img src="images/order_ed.jpg">
								</s:else></td>

						</tr>
						<%
							i = i + 1;
						%>
					</s:iterator>
				</table>
			</div>
			<div id="apDiv5">
				<input type="text" name="selected_date2" value="">
			</div>
			<div id="apDiv1">
				<input type="image" src="images/submit_btn.jpg" onclick="submit()"
					width="40" height="20" border="0">
			</div>
			<div id="apDiv2">
				<input type="image" src="images/reset_btn.jpg"
					onClick="return resetBtn(this.form);" width="40" height="20"
					border="0">
			</div>

		</form>
	</font>
</body>
</html>
