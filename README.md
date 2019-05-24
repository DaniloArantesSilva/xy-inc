
<h1>xy - inc</h1>
Plataforma para auxiliar pessoas na localização de ponto de interesse (POIs).

<h3>Dependências</h3>

Java 8</br>
Maven 3.6.0</br>
Banco de dados MySQL</br>
Spring</br>
JPA</br>
Spring Tool Suite (versão 3.9.5 ou superior)</br>
JUnit

<h3>Como configurar a aplicação</h3>

<b>.</b> Baixe o projeto com o comando git clone https://github.com/DaniloArantesSilva/xy-inc.git.</br>
<b>.</b> Abra a IDE Spring Tool Suite e importe o projeto com o Maven: File - Import... - Maven - Existing Maven Projects.</br>
<b>.</b> Aguarde até o Maven baixar todas as dependências do projeto.</br>
<b>.</b> Crie um banco de dados no MySQL com o nome xyinc.</br>
<b>.</b> Caso a senha do seu banco de dados não for a padrão deve ser alterada no arquivo src/main/resources/application.properties.</br>
<b>.</b> O projeto já está pronto pra uso e pode ser inicializado clicando com o botão direito do mouse, na opção Run As e clicando na opção Spring Boot App.</br>
<b>.</b> A aplicação será acessível na URL: http://localhost:8080.</br>
<b>.</b> Para executar os testes automatizados basta ir no pacote dos mesmos, clicar com o botão direito e ir em Run As - JUnit Test.


<h3>Serviços da API REST</h3>
<table>
  <tbody>
    <tr>
      <td>POST</td>
      <td>/poi</td>
      <td>cadastra um novo ponto de interesse</td>
      <td>exemplo: {"nome": "string", "coordenadaX": long, "coordenadaY": long}
    </tr>    
    <tr>
      <td>GET</td>
      <td>/poi</td>
      <td>Lista todos os POIs cadastrados.</td>
      <td/>
    </tr>
    <tr>
      <td>GET</td>
      <td>/poi/search?coordenadaX={x}&coordenadaY={y}&distanciaMax={dmax}</td>
      <td>Lista POIs por proximidade passando como parâmetro a coordenada x, a coordenada y e a distância máxima.</td>
      <td>exemplo: http://localhost:8080/poi/search?coordenadaX=20&coordenadaY=10&distanciaMax=10</td>
    </tr>
  </tbody>
</table>
