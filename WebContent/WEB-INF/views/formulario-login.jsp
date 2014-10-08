<html>
<head>
	<title>Bem Vindo - Faça o login para continuar</title>
	<meta charset='utf-8'>
	<link type="text/css" href="resources/css/estilo.css" rel="stylesheet" />
	<link rel="shortcut icon" href="resources/css/favicon.png" width="24" height="24">
</head>
<body>
<div class="externa">
	<div class="containerExternologin">
		<div class="login">
			<form id="formLogin" action="efetuaLogin" method="post">
				<table>
					<tr>
						<td colspan="2" align="center" height="150">
							<img src="resources/css/logo.png" width="120" height="97"/>
						</td>
					</tr>
					<tr>
						<td align=right height="40">
							Usuário
						</td>
						<td>
							<input type="text" name="login" required><br>
						</td>
					</tr>
					<tr>
						<td align=right height="40">
							Senha
						</td>
						<td>
							<input type="password" name="senha" required><br>
						</td>
					</tr>
					<tr>
						<td colspan="2" align=right height="40">
							<button type="submit" class="btn_login">Login</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>
</body>
</html>