package cadastrocliente;

import java.util.Scanner;
import java.util.ArrayList;

public class CadastroCliente {
    
    
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<String> clientesNomes = new ArrayList<>();
        boolean continuar = true;
        int funcao = 0;
        
        
              
        
        while(continuar == true){
            
            switch(selecionarFuncao()){

                //Adicionar cliente
                case 1:
                    funcao = 1;
                    Cliente c = new Cliente();
                    //setar dados
                    setDados(c);
                    //verificar se já existe esse cliente
                    if(procurarCliente(clientes,c) == -1){
                        c.mostrarDados();
                        clientes.add(c);
                        clientesNomes.add(c.getNome());
                    }else{
                        System.out.println("[ERRO]Já existe esse cliente!");
                    }
                    
                    System.out.println("Deseja Realizar mais operações?(s/n)");
                    String resposta = leitor.nextLine();
                    continuar = "s".equals(resposta);
                    c = null;
                    break;
                //Atualizar cliente
                case 2:
                    funcao = 2;
                    System.out.println("Procurar Cliente>");
                    String clienteProcurado = leitor.next();
                    //verifica se já existe o cliente
                    int index = procurarCliente2(clientesNomes, clienteProcurado);
                    //System.out.println(index);
                    if(index != -1){
                        
                    }else{
                        System.out.println("[Erro] Não existe esse cliente!");
                        break;
                    }
                    
                    //Cliente apenas pra chamar a funcao
                    Cliente c2 = clientes.get(index);
                    boolean retorno = (c2.compararDados(c2));
                    
                    //se os dados forem iguais
                    if(retorno){
                        System.out.println("Digite os novos dados");
                        setDados(c2);
                    }
                    else{ //se nao forem sai do loop
                        System.out.println("Algo deu errado...Tente novamente");
                        break;
                    }
                    //Adiciona a lista
                    c2.mostrarDados();
                    clientes.add(c2);
                    c2 = null;
                    //Verifica se quer continuar
                    System.out.println("Deseja Realizar mais operações?(s/n)");
                    resposta = leitor.nextLine();
                    continuar = "s".equals(resposta);
                    break;
                //Excluir cliente
                case 3:
                    funcao = 3;
                    System.out.println("Seleiconar Cliente>");
                    //Varáveis já atribuidas no case2 
                    clienteProcurado = leitor.next();
                    //verifica se já existe o cliente
                    index = procurarCliente2(clientesNomes, clienteProcurado);
                    
                    if(index != -1){
                        System.out.println("Achou!");
                    }else{
                        System.out.println("[Erro] Não existe esse cliente!");
                        break;
                    }
                    
                    Cliente c3 = clientes.get(index);
                    retorno = (c3.compararDados(c3));
                    
                    //se os dados forem iguais
                    if(retorno){
                        System.out.println("[Cuidado]Deseja realmente excluir o cliente?");
                        System.out.println("Digite s/n");
                        if(leitor.next().equals("s")){
                            clientes.remove(index);
                        }else{
                            System.out.println("Operação cancelada");
                        }
                        break;
                    }
                    else{ //se nao forem sai do loop
                        System.out.println("Algo deu errado...Tente novamente");
                        break;
                    }
                   
            }
        }
        
        clientes.forEach((cliente) -> {
            cliente.mostrarDados();
        });
        
    }
    
    public static int selecionarFuncao(){
        
        Scanner leitor = new Scanner(System.in);

        //Menu
        System.out.println("Qual operação você deseja fazer?");
        System.out.println("1- Cadastrar Cliente");
        System.out.println("2- Atualizar Cliente");
        System.out.println("3- Excluir Cliente");
        System.out.print(">");
        int opcao = Integer.parseInt(leitor.next());
        
        return opcao;
    }
    
    public static void setDados(Cliente cliente){
        
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Nome:");
        cliente.setNome(leitor.nextLine());
        System.out.println("Número:");
        cliente.setNumero(leitor.nextInt());
        System.out.println("CPF (apenas números):");
        cliente.setCpf(leitor.nextLong());
        System.out.println("Genero(m/f):");
        cliente.setGenero(leitor.next());
        System.out.println("Endereço(bairro,rua,numero):");
        String bairro = leitor.next();
        String rua = leitor.next();
        String numero = leitor.next();
        cliente.setEndereco(bairro, rua, numero);
        System.out.println("Cliente Adicionado!");
    } 
    
    public static int procurarCliente(ArrayList<Cliente> lista, Cliente c){
        int index = lista.indexOf(c);
        return index;    
    }
    
    public static int procurarCliente2(ArrayList<String> lista, String c){
        int index = lista.indexOf(c);
        return index;    
    }
}
