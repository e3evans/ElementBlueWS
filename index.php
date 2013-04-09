<html>
	<head>
		
		<!-- chars -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<!-- meta -->
		<title>Aurora Landing Page</title>
		
		<!--[if lte IE 8]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		
		<!-- styles -->
		<link type="text/css" rel="stylesheet" href="/assets/css/common.css" />
		<link type="text/css" rel="stylesheet" href="/assets/css/fonts.css" />
		<link type="text/css" rel="stylesheet" href="/assets/css/styles.css" />
		
		<!-- scripts -->
		<script src="/assets/js/jquery.1.8.2.js" type="text/javascript"></script>
		<script src="/assets/js/behavoir.js" type="text/javascript"></script>
		
	</head>
	<body>
		<?php
			
			/***************************************/
			/************ HEADER ELEMENT ***********/
			/***************************************/
			include('elements/header.php');
			
			/***************************************/
			/************* MAIN NAV ELEMENT ********/
			/***************************************/
			include('elements/mainnav.php');
			
			/***************************************/
			/********** LANDING PAGE VIEW **********/
			/***************************************/
			include('view/landingpage.php');
			
			/***************************************/
			/************ FOOTER ELELEMENT *********/
			/***************************************/
			include('elements/footer.php');
			
		?>
	</body>
</html>