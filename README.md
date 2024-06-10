A3 - Empréstimo de Ferramentas 
---
Integrantes:
* Pedro Henrique Nieto da Silva - RA: 1072411483
	* Pedroo-Nietoo
	* Pedro Nieto
* Heitor - RA: 1072410915
	* HeitorWestphal
	* heito
* Vinicius Freitas da Silva - RA:17024113796
	* Vinicius-Freitas-da-Silva
	* Vinicius Freitas da Silva
	* Vinicius
	* PenRoseRubix
* Ian - RA: 1072410937
	* Ian Santiago Silveira
* João Pedro Nobile dos Santos - RA:1072411014
	* jpzyn
---
### **Requisitos funcionais**

- RF01	- Cadastro de ferramentas: O software deve permitir que o usuário cadastre as ferramentas, como nome, marca e custo.
 - RF02 - Cadastro d  e amigos: O software deve permitir que o usuário cadastre os dados dos amigos, como nome, e-mail e telefone.
- RF03 - Registro de empréstimos: O software deve permitir que o usuário registre os empréstimos de ferramentas para os amigos, informando a ferramenta, o amigo, a data do empréstimo e os dados previstos de devolução.
-  RF04 - Registro de empréstimos: O software deve mostrar um aviso ao usuário a cada novo empréstimo se a uma pendência de devolução.
- RF05 - Relatório de ferramentas: O software deve gerar um relatório com todas as ferramentas cadastradas, informando a descrição e o valor de cada uma, bem como o gasto total com a aquisição das ferramentas.
- RF06 - Relatório de empréstimos ativos: O software deve gerar um relatório com todos os empréstimos que estão ativos, informando a ferramenta emprestada, o amigo que pegou emprestado, a data do empréstimo e os dados previstos de devolução.
- RF07 - Relatório de empréstimos pendentes: o software deve gerar um relatório com todos os empréstimos que ultrapassaram o tempo de devolução, informando a ferramenta emprestada, o amigo que pegou emprestado, a data que o empréstimo foi realizado e a data de devolução limite.
- RF08 - Relatório de todos os empréstimos: O software deve gerar um relatório com todos os empréstimos realizados, informando a ferramenta emprestada, o amigo que pegou emprestado, se o empréstimo está ativo ou pendente, a data de empréstimo, a data limite de devolução e qual amigo faz mais empréstimos.
- RF09 - Agenda integrada: O software deve compartilhar os lembretes de avisos dos eventos por e-mail.
- RF10 - Verificação de ferramentas não devolvidas: O software deve verificar a cada novo empréstimo se o amigo ainda tem ferramentas não devolvidas e informar ao usuário.

 ---
### Requisitos não funcionais

- RNF01 - Localização: O software deve ser executado localmente no computador do usuário, sem necessidade de conexão com a internet.
- RNF02 - Interface Amigável: O software deve ter uma interface fácil de usar e intuitiva, adequada para usuários não técnicos, como o tio-avô.	
- RNF03 - Segurança: O software deve garantir a segurança dos dados cadastrados, protegendo informações pessoais e financeiras dos usuários.
- RNF04 -  Integração com o Google agenda: O sistema deve integrar-se de forma eficaz e confiável com a Google agenda, garantindo o compartilhamento correto de lembretes de eventos.

---
### Regras de negócio
- NE001 - Uma ferramenta só pode ser emprestada para um amigo de cada vez.
- NE002 - O custo de aquisição de uma ferramenta deve ser um valor positivo.
-  NE003 - O nome de uma ferramenta, marca e o nome de um amigo não podem estar em branco.
- NE004 - Data de devolução de uma ferramenta emprestada não pode ser anterior à data de empréstimo.

---
### Versões
- Apache NetBeans IDE 17
- Java 8
- Windows 10
- MySQL Workbench 8.0
---
### Link do Vídeo 
https://drive.google.com/file/d/1GP0l1wKjGTQhprNHfRysSrwBB5U0KudH/view?usp=drivesdk


### Observação
- O Bruno está como Contributor porque eu (Pedro Nieto) tive problemas em meu computador na Unisul e tive de commitar as alterações através do computador dele.
