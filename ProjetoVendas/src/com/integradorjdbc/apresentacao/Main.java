package com.integradorjdbc.apresentacao;
import java.util.List;
import java.util.Scanner;
import com.integradorjdbc.model.Produto;
import com.integradorjdbc.model.Distribuidor;
import com.integradorjdbc.model.Telefone;
import com.integradorjdbc.model.Cliente;
import com.integradorjdbc.model.Endereco;
import com.integradorjdbc.persistencia.ClienteDAO;
import com.integradorjdbc.persistencia.DistribuidorDAO;
import com.integradorjdbc.persistencia.EnderecoDAO;
import com.integradorjdbc.persistencia.ProdutoDAO;
import com.integradorjdbc.persistencia.TelefoneDAO;


public class Main {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int ii=0;
		Cliente clie = new Cliente();
		Produto prod = new Produto();
		ProdutoDAO proDAO = new ProdutoDAO();		
		ClienteDAO cliDAO = new ClienteDAO();
		Distribuidor dis = new Distribuidor();
		DistribuidorDAO disDAO = new DistribuidorDAO();
		Endereco end = new Endereco();
		EnderecoDAO endDAO= new EnderecoDAO();
		Telefone tel = new Telefone();
		TelefoneDAO telDAO = new TelefoneDAO();
		
		System.out.println("---Bem vindo ao CD Mobile---");
		System.out.println("1. Login");
		System.out.println("2. Cadastro");
		int x = sc.nextInt();
		
		switch (x){
		case 2:
			System.out.println("Digite seu nome completo: ");
			String nome = sc.next();

                        
			System.out.println("Digite seu email:");
			String email = sc.next();
	
			System.out.println("Digite sua senha: ");
			String senha = sc.next();

			dis= new Distribuidor(0, nome, email, senha);
			disDAO.cadastrar(dis);
                        dis=disDAO.login(email, senha);
			
			System.out.println("---Bem vindo ao CD Mobile---");
			System.out.println("1. Login");
			System.out.println("2. Cadastro");
			int i = sc.nextInt();
			
			switch(i){
			case 1:
				System.out.println("Digite seu email: ");
				String logmail = sc.next();
				dis.setEmailDistribuidor(logmail);
				System.out.println("Digite sua senha: ");
				String logsenha = sc.next();
				dis.setSenha(logsenha);
				disDAO.login(logmail, logsenha);
				
				do{					
					System.out.println(" 1.Cadastrar novos clientes\n 2.Buscar clientes/atualizar/deletar\n 3.Cadastrar novos produtos/atualizar/deletar \n 4. Enderecos\n 5. Telefones \n 6.Encerrar");
					int iii = sc.nextInt();
					if (iii==6){
						System.out.println("Sess�o encerrada");
						System.exit(0);
					}
					switch(iii){
					case 1:
						System.out.println("Cadastro de novos clientes: ");
						System.out.println("Nome do cliente: ");
						String nomecl = sc.next();
						clie.setNomeCliente(nomecl);
						System.out.println("Email do cliente: ");
						String emailcl = sc.next();
						clie.setEmailCliente(emailcl);
                                                System.out.println("Pedido do cliente: ");
						String pedicl = sc.next();
						clie.setPedido(pedicl);
						System.out.println("Cnpj do cliente: ");
						String cnpjcl = sc.next();
						clie.setCnpj(cnpjcl);	
						
                                                clie= new Cliente(0, nome, email, pedicl, cnpjcl, null);
						cliDAO.cadastrar(clie);
					
						
						System.out.println("1. Voltar\n 2.Encerrar");
						ii = sc.nextInt();
						break;
						
					case 2:
						System.out.println("O que deseja fazer?? ");
						System.out.println("1. Buscar por ID: ");
						System.out.println("2. Buscar por e-Mail: ");
						System.out.println("3. Atualizar um cliente: ");
						System.out.println("4. Deletar um cliente");
						System.out.println("5. Buscar todos");
						int opc = sc.nextInt();
						if (opc==1){
							System.out.println("Digite o ID do cliente que deseja buscar? ");
							long id1 = sc.nextLong();
							
							Cliente buscaId = cliDAO.buscarPorId(id1);
							System.out.println(buscaId.toString());
							break;
						}
						if (opc==2){
							System.out.println("Digite o email do cliente que deseja buscar: ");
							String email2 = sc.next();
							Cliente buscaEmail = (cliDAO.buscarPorEmail(email2));
							System.out.println(buscaEmail.toString());
							break;
						}
						if(opc==3){
							System.out.println("Digite o ID do cliente que deseja editar: ");
							long id1 = sc.nextLong();
							clie.setIdCliente((long)id1);
							
							System.out.println("Nome do cliente: ");
							String nome2 = sc.next();
							clie.setNomeCliente(nome2);
							System.out.println("Email do cliente: ");
							String email2 = sc.next();
							clie.setEmailCliente(email2);
							System.out.println("Cnpj do cliente: ");
							String cnpj2 = sc.next();
							clie.setCnpj(cnpj2);
							System.out.println("Foto do cliente(Link)");
							String foto2 = sc.next();
							clie.setFotoCliente(foto2);
							System.out.println("Pedido do cliente: ");
							String pedi2 = sc.next();
							clie.setPedido(pedi2);
							cliDAO.editar(clie);
							System.out.println("Editado!");
							break;							
						}
						if (opc==4){
							System.out.println("Digite o ID do cliente que ser� excluido: ");
							long id2 = sc.nextLong();
							cliDAO.excluir(id2);
							break;
						}if(opc==5){
							List<Cliente> listaCliente = cliDAO.buscarTodos();
							for (int y = 0; x < listaCliente.size(); y++) {
								System.out.println(listaCliente.get(y).toString());
							}
						}
					case 3:
						System.out.println("1. Inserir um novo produto ");
						System.out.println("2. Editar um produto: ");
						System.out.println("3. Buscar um produto por id: ");
						System.out.println("4. Buscar um produto por categoria: ");
						System.out.println("5. Excluir um produto: ");
						System.out.println("6. Buscar todos: ");
						int opc2 = sc.nextInt();
						if (opc2 == 1){
							System.out.println("Qual o nome do produto: ");
							String nomep = sc.next();
							prod.setNomeProduto(nomep);
							System.out.println("Foto do produto(Link): ");
							String fotop = sc.next();
							prod.setFotoProduto(fotop);
							System.out.println("Preco do produto: ");
							float precop = sc.nextFloat();
							prod.setPreco(precop);
							System.out.println("Qual a categoria desse produto: ");
							String catP = sc.next();
							prod.setCategoria(catP);
							prod = new Produto(0, nomep, fotop, precop, catP, null);
							proDAO.cadastrar(prod);		
							System.out.println("Cadastrado");
							break;
						}if(opc2 ==2){
							System.out.println("Digite o ID do produto qual voc� deseja editar: ");
							long idP = sc.nextLong();
							prod.setIdProduto((long)idP);
							System.out.println("Qual o nome do produto: ");
							String nomep = sc.next();
							prod.setNomeProduto(nomep);
							System.out.println("Foto do produto(Link): ");
							String fotop = sc.next();
							prod.setFotoProduto(fotop);
							System.out.println("Preco do produto: ");
							float precop = sc.nextFloat();
							prod.setPreco(precop);
							System.out.println("Qual a categoria desse produto: ");
							String catP = sc.next();
							prod.setCategoria(catP);
							proDAO.editar(prod);	
							System.out.println("Editado!");
							break;
							
						}if(opc2==3){
							System.out.println("Digite o ID do produto qual voc� procura: ");
							long idP = sc.nextLong();
							Produto buscaId = proDAO.buscarPorId(idP);
							System.out.println(buscaId.toString());
							break;
						}if(opc2==4){
							System.out.println("Digite a categoria do produto que voc� quer");
							String catp = sc.next();
							Produto buscaCa = proDAO.buscarPorCategoria(catp);
							System.out.println(buscaCa.toString());
							break;
						}if(opc2==5){
							System.out.println("Digite o ID do produto qual voc� deixa excluir: ");
							long exc = sc.nextLong();
							prod.setIdProduto(exc);
							proDAO.excluir((long)exc);	
							System.out.println("Excluido!");
							break;
							
							}if(opc2==6){
								List<Produto> listaProduto = proDAO.buscarTodos();
								for (int y = 0; x < listaProduto.size(); y++) {
									System.out.println(listaProduto.get(y).toString());
							}					
							}
					case 4:
						System.out.println("1. Cadastrar um endereco para o cliente: ");
						System.out.println("2. Editar um endereco: ");
						System.out.println("3. Buscar um endereco pelo id: ");						
						System.out.println("4. Excluir um endereco: ");
						System.out.println("5. Buscar todos: ");
						int opc3 = sc.nextInt();
						if (opc3 == 1){
							System.out.println("Qual o CEP: ");
							String cep1 = sc.next();
							end.setCep(cep1);
							System.out.println("Qual o UF? ");
							String uf1 = sc.next();
							end.setUf(uf1);
							System.out.println("Qual o estado: ");
							String est1 = sc.next();
							end.setEstado(est1);
							System.out.println("Qual a cidade: ");
							String city = sc.next();
							end.setCidade(city);
							System.out.println("Qual o bairro: ");
							String bai = sc.next();
							end.setBairro(bai);
							System.out.println("Qual a rua: ");
							String rua = sc.next();
							end.setRua(rua);
							System.out.println("Qual o numero: ");
							long num = sc.nextLong();
							end.setNumero(num);							
							end.setIdEndereco(1l);
							endDAO.cadastrar(end);	
							System.out.println("Cadastrado");
							break;
						}if(opc3 ==2){
							System.out.println("Digite o id do endereco qual voc� deseja editar: ");
							long ende = sc.nextLong();
							end.setIdEndereco((long)ende);
							System.out.println("Qual o CEP: ");
							String cep1 = sc.next();
							end.setCep(cep1);
							System.out.println("Qual o UF? ");
							String uf1 = sc.next();
							end.setUf(uf1);
							System.out.println("Qual o estado: ");
							String est1 = sc.next();
							end.setEstado(est1);
							System.out.println("Qual a cidade: ");
							String city = sc.next();
							end.setCidade(city);
							System.out.println("Qual o bairro: ");
							String bai = sc.next();
							end.setBairro(bai);
							System.out.println("Qual a rua: ");
							String rua = sc.next();
							end.setRua(rua);
							System.out.println("Qual o numero: ");
							long num = sc.nextLong();
							end.setNumero(num);					
							endDAO.editar(end);	
							System.out.println("Editado!");
							break;
							
						}if(opc3==3){
							System.out.println("Digite o ID do endereco qual voc� procura: ");
							long ide = sc.nextLong();
							Produto buscaEnd = proDAO.buscarPorId(ide);
							System.out.println(buscaEnd.toString());
							break;
						}
						if(opc3==4){
							System.out.println("Digite o ID do endereco qual voc� deixa excluir: ");
							long exc = sc.nextLong();
							end.setIdEndereco(exc);
							endDAO.excluir((long)exc);	
							System.out.println("Excluido!");
							break;
							
							}if(opc3==5){
								List<Endereco> listaEndereco = endDAO.buscarTodos();
								for (int y = 0; x < listaEndereco.size(); y++) {
									System.out.println(listaEndereco.get(y).toString());
							}					
							}
					case 5:
						System.out.println("1. Inserir um novo telefone ");
						System.out.println("2. Editar um telefone: ");
						System.out.println("3. Buscar um telefone por id: ");
						System.out.println("4. Buscar um telefone por numero: ");
						System.out.println("5. Excluir um telefone: ");
						System.out.println("6. Buscar todos: ");
						int opc4 = sc.nextInt();
						if (opc4 == 1){
							System.out.println("Qual o ddd: ");
							String ddd1 = sc.next();
							tel.setDdd(ddd1);
							System.out.println("Digite o numero do telefone: ");
							String num2 = sc.next();
							tel.setNumero(num2);						
							tel.setIdTelefone(1l);
							telDAO.cadastrar(tel);		
							System.out.println("Cadastrado");
							break;
						}if(opc4 ==2){
							System.out.println("Digite o ID do produto qual voc� deseja editar: ");
							long idP = sc.nextLong();
							tel.setIdTelefone((long)idP);
							System.out.println("Qual o ddd: ");
							String ddd1 = sc.next();
							tel.setDdd(ddd1);
							System.out.println("Digite o numero do telefone: ");
							String num2 = sc.next();
							telDAO.editar(tel);	
							System.out.println("Editado!");
							break;
							
						}if(opc4==3){
							System.out.println("Digite o ID do produto qual voc� procura: ");
							long idP = sc.nextLong();
							Telefone buscaIdt = telDAO.buscarPorId(idP);
							System.out.println(buscaIdt.toString());
							break;
						}if(opc4==4){
							System.out.println("Digite o numero do telefone que voc� quer");
							String nume = sc.next();
							Telefone buscaTe = telDAO.buscarPorNumero(nume);
							System.out.println(buscaTe.toString());
							break;
						}if(opc4==5){
							System.out.println("Digite o ID do produto qual voc� deixa excluir: ");
							long exc = sc.nextLong();
							tel.setIdTelefone(exc);
							proDAO.excluir((long)exc);	
							System.out.println("Excluido!");
							break;
							
							}if(opc4==6){
								List<Telefone> listaTelefone = telDAO.buscarTodos();
								for (int y = 0; x < listaTelefone.size(); y++) {
									System.out.println(listaTelefone.get(y).toString());
								}}
						
					}
					
						
				}while(ii != 6);
				
			}
		case 1:
			System.out.println("Digite seu email: ");
			String logmail = sc.next();
			dis.setEmailDistribuidor(logmail);
			System.out.println("Digite sua senha: ");
			String logsenha = sc.next();
			dis.setSenha(logsenha);
			disDAO.login(logmail, logsenha);
			
			do{					
				System.out.println("1.Cadastrar novos clientes\n 2.Buscar clientes/atualizar/deletar\n 3.Cadastrar novos produtos/atualizar/deletar \n 4. Enderecos\n 5. Telefones \n 6.Encerrar");
				int iii = sc.nextInt();
				if (ii==4){
					System.out.println("Sess�o encerrada");
					System.exit(0);
				}
				switch(iii){
				case 1:
					System.out.println("Cadastro de novos clientes: ");
					System.out.println("Nome do cliente: ");
					String nomecl = sc.next();
					clie.setNomeCliente(nomecl);
					System.out.println("Email do cliente: ");
					String emailcl = sc.next();
					clie.setEmailCliente(emailcl);
					System.out.println("Cnpj do cliente: ");
					String cnpjcl = sc.next();
					clie.setCnpj(cnpjcl);					
					System.out.println("Pedido do cliente: ");
					String pedicl = sc.next();
					clie.setPedido(pedicl);                               
					cliDAO.cadastrar(clie);
					
					
					System.out.println("1. Voltar\n 2.Encerrar");
					ii = sc.nextInt();
					break;
					
				case 2:
					System.out.println("O que deseja fazer?? ");
					System.out.println("1. Buscar por ID: ");
					System.out.println("2. Buscar por e-Mail: ");
					System.out.println("3. Atualizar um cliente: ");
					System.out.println("4. Deletar um cliente");
					System.out.println("5. Buscar todos");
					int opc = sc.nextInt();
					if (opc==1){
						System.out.println("Digite o ID do cliente que deseja buscar? ");
						long id1 = sc.nextLong();
						
						Cliente buscaId = cliDAO.buscarPorId(id1);
						System.out.println(buscaId.getNomeCliente());
						break;
					}
					if (opc==2){
						System.out.println("Digite o email do cliente que deseja buscar: ");
						String email2 = sc.next();
						Cliente buscaEmail = (cliDAO.buscarPorEmail(email2));
						System.out.println(buscaEmail.toString());
						break;
					}
					if(opc==3){
						System.out.println("Digite o ID do cliente que deseja editar: ");
						long id1 = sc.nextLong();
						clie.setIdCliente((long)id1);
						
						System.out.println("Nome do cliente: ");
						String nome2 = sc.next();
						clie.setNomeCliente(nome2);
						System.out.println("Email do cliente: ");
						String email2 = sc.next();
						clie.setEmailCliente(email2);
						System.out.println("Cnpj do cliente: ");
						String cnpj2 = sc.next();
						clie.setCnpj(cnpj2);
						System.out.println("Foto do cliente(Link)");
						String foto2 = sc.next();
						clie.setFotoCliente(foto2);
						System.out.println("Pedido do cliente: ");
						String pedi2 = sc.next();
						clie.setPedido(pedi2);
						cliDAO.editar(clie);
						System.out.println("Editado!");
						break;							
					}
					if (opc==4){
						System.out.println("Digite o ID do cliente que ser� excluido: ");
						long id2 = sc.nextLong();
						cliDAO.excluir(id2);
						break;
					}if(opc==5){
						List<Cliente> listaCliente = cliDAO.buscarTodos();
						for (int y = 0; x < listaCliente.size(); y++) {
							System.out.println(listaCliente.get(y).getNomeCliente());
                                              
						}
                                                break;
					}
				case 3:
					System.out.println("1. Inserir um novo produto ");
					System.out.println("2. Editar um produto: ");
					System.out.println("3. Buscar um produto por id: ");
					System.out.println("4. Buscar um produto por categoria: ");
					System.out.println("5. Excluir um produto: ");
					System.out.println("6. Buscar todos: ");
					int opc2 = sc.nextInt();
					if (opc2 == 1){
						System.out.println("Qual o nome do produto: ");
						String nomep = sc.next();
						prod.setNomeProduto(nomep);
						System.out.println("Foto do produto(Link): ");
						String fotop = sc.next();
						prod.setFotoProduto(fotop);
						System.out.println("Preco do produto: ");
						float precop = sc.nextFloat();
						prod.setPreco(precop);
						System.out.println("Qual a categoria desse produto: ");
						String catP = sc.next();
						prod.setCategoria(catP);
						proDAO.cadastrar(prod);		
						System.out.println("Cadastrado");
						break;
					}if(opc2 ==2){
						System.out.println("Digite o ID do produto qual voc� deseja editar: ");
						long idP = sc.nextLong();
						prod.setIdProduto((long)idP);
						System.out.println("Qual o nome do produto: ");
						String nomep = sc.next();
						prod.setNomeProduto(nomep);
						System.out.println("Foto do produto(Link): ");
						String fotop = sc.next();
						prod.setFotoProduto(fotop);
						System.out.println("Preco do produto: ");
						float precop = sc.nextFloat();
						prod.setPreco(precop);
						System.out.println("Qual a categoria desse produto: ");
						String catP = sc.next();
						prod.setCategoria(catP);
						proDAO.editar(prod);	
						System.out.println("Editado!");
						break;
						
					}if(opc2==3){
						System.out.println("Digite o ID do produto qual voc� procura: ");
						long idP = sc.nextLong();
						Produto buscaId = proDAO.buscarPorId(idP);
						System.out.println(buscaId.toString());
						break;
					}if(opc2==4){
						System.out.println("Digite a categoria do produto que voc� quer");
						String catp = sc.next();
						Produto buscaCa = proDAO.buscarPorCategoria(catp);
						System.out.println(buscaCa.toString());
						break;
					}if(opc2==5){
						System.out.println("Digite o ID do produto qual voc� deixa excluir: ");
						long exc = sc.nextLong();
						prod.setIdProduto(exc);
						proDAO.excluir((long)exc);	
						System.out.println("Excluido!");
						break;
						
						}if(opc2==6){
							List<Produto> listaProduto = proDAO.buscarTodos();
							for (int y = 0; x < listaProduto.size(); y++) {
								System.out.println(listaProduto.get(y).toString());
						}					
						}
				case 4:
					System.out.println("1. Cadastrar um endereco para o cliente: ");
					System.out.println("2. Editar um endereco: ");
					System.out.println("3. Buscar um endereco pelo id: ");						
					System.out.println("4. Excluir um endereco: ");
					System.out.println("5. Buscar todos: ");
					int opc3 = sc.nextInt();
					if (opc3 == 1){
						System.out.println("Qual o CEP: ");
						String cep1 = sc.next();
						end.setCep(cep1);
						System.out.println("Qual o UF? ");
						String uf1 = sc.next();
						end.setUf(uf1);
						System.out.println("Qual o estado: ");
						String est1 = sc.next();
						end.setEstado(est1);
						System.out.println("Qual a cidade: ");
						String city = sc.next();
						end.setCidade(city);
						System.out.println("Qual o bairro: ");
						String bai = sc.next();
						end.setBairro(bai);
						System.out.println("Qual a rua: ");
						String rua = sc.next();
						end.setRua(rua);
						System.out.println("Qual o numero: ");
						long num = sc.nextLong();
						end.setNumero(num);							
						end.setIdEndereco(1l);
						endDAO.cadastrar(end);	
						System.out.println("Cadastrado");
						break;
					}if(opc3 ==2){
						System.out.println("Digite o id do endereco qual voc� deseja editar: ");
						long ende = sc.nextLong();
						end.setIdEndereco((long)ende);
						System.out.println("Qual o CEP: ");
						String cep1 = sc.next();
						end.setCep(cep1);
						System.out.println("Qual o UF? ");
						String uf1 = sc.next();
						end.setUf(uf1);
						System.out.println("Qual o estado: ");
						String est1 = sc.next();
						end.setEstado(est1);
						System.out.println("Qual a cidade: ");
						String city = sc.next();
						end.setCidade(city);
						System.out.println("Qual o bairro: ");
						String bai = sc.next();
						end.setBairro(bai);
						System.out.println("Qual a rua: ");
						String rua = sc.next();
						end.setRua(rua);
						System.out.println("Qual o numero: ");
						long num = sc.nextLong();
						end.setNumero(num);					
						endDAO.editar(end);	
						System.out.println("Editado!");
						break;
						
					}if(opc3==3){
						System.out.println("Digite o ID do endereco qual voc� procura: ");
						long ide = sc.nextLong();
						Endereco buscaEnd = endDAO.buscarPorId(ide);
						System.out.println(buscaEnd.toString());
						break;
					}
					if(opc3==4){
						System.out.println("Digite o ID do endereco qual voc� deixa excluir: ");
						long exc = sc.nextLong();
						end.setIdEndereco(exc);
						endDAO.excluir((long)exc);	
						System.out.println("Excluido!");
						break;
						
						}if(opc3==5){
							List<Endereco> listaEndereco = endDAO.buscarTodos();
							for (int y = 0; x < listaEndereco.size(); y++) {
								System.out.println(listaEndereco.get(y).toString());
						}					
						}
				case 5:
					System.out.println("1. Inserir um novo telefone ");
					System.out.println("2. Editar um telefone: ");
					System.out.println("3. Buscar um telefone por id: ");
					System.out.println("4. Buscar um telefone por numero: ");
					System.out.println("5. Excluir um telefone: ");
					System.out.println("6. Buscar todos: ");
					int opc4 = sc.nextInt();
					if (opc4 == 1){
						System.out.println("Qual o ddd: ");
						String ddd1 = sc.next();
						tel.setDdd(ddd1);
						System.out.println("Digite o numero do telefone: ");
						String num2 = sc.next();
						tel.setNumero(num2);						
						tel.setIdTelefone(1l);
						telDAO.cadastrar(tel);		
						System.out.println("Cadastrado");
						break;
					}if(opc4 ==2){
						System.out.println("Digite o ID do produto qual voc� deseja editar: ");
						long idP = sc.nextLong();
						tel.setIdTelefone((long)idP);
						System.out.println("Qual o ddd: ");
						String ddd1 = sc.next();
						tel.setDdd(ddd1);
						System.out.println("Digite o numero do telefone: ");
						String num2 = sc.next();
						telDAO.editar(tel);	
						System.out.println("Editado!");
						break;
						
					}if(opc4==3){
						System.out.println("Digite o ID do produto qual voc� procura: ");
						long idP = sc.nextLong();
						Telefone buscaIdt = telDAO.buscarPorId(idP);
						System.out.println(buscaIdt.toString());
						break;
					}if(opc4==4){
						System.out.println("Digite o numero do telefone que voc� quer");
						String nume = sc.next();
						Telefone buscaTe = telDAO.buscarPorNumero(nume);
						System.out.println(buscaTe.toString());
						break;
					}if(opc4==5){
						System.out.println("Digite o ID do produto qual voc� deixa excluir: ");
						long exc = sc.nextLong();
						tel.setIdTelefone(exc);
						proDAO.excluir((long)exc);	
						System.out.println("Excluido!");
						break;
						
						}if(opc4==6){
							List<Telefone> listaTelefone = telDAO.buscarTodos();
							for (int y = 0; x < listaTelefone.size(); y++) {
								System.out.println(listaTelefone.get(y).toString());
							}}
					
				}
				
					
			}while(ii != 6);
			
		}
			
		}
		
		
		
		
	}


