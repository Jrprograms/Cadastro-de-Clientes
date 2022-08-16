package cadastrocliente;

import java.util.Scanner;

public class Cliente {
    
    private String nome;
    private int numero;
    private long cpf;
    private String genero;
    private String[] endereco = new String[3];
    
    //Funções Getters e Setters
    public void setNome(String nome){
        this.nome = nome; 
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNumero(int num){
        this.numero = num; 
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public void setCpf(long cpf){
        this.cpf = cpf; 
    }
    
    public long getCpf(){
        return this.cpf;
    }
    
    public void setGenero(String gen){
        this.genero = gen;
    }
    
    public String getGenero(){
        return this.genero;
    }
    
    public void setEndereco(String bairro, String rua, String numero){
        this.endereco[0] = bairro;
        this.endereco[1] = rua;
        this.endereco[2] = numero;
    }
    
    public String getEndereco(int pos){
        return this.endereco[pos];
    }
    
    public void mostrarDados(){
        System.out.println("Dados do Cliente:");
        System.out.println(getNome() + " " + getNumero() + " " + getGenero() + " " + getCpf() + " " + getEndereco(0) + "," + getEndereco(1) + "," + getEndereco(2));
    }
    
    public boolean compararDados(Cliente c){
       
        //variavel para verificar se está igual os valores
        boolean igual = false;
        
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Nome:");
        String nome2 = leitor.nextLine();
        igual = nome.equals(c.nome);
        System.out.println("Número:");
        long numero2 = leitor.nextLong();
        igual = (numero2 == c.numero);
        System.out.println("CPF (apenas números):");
        String cpf2 = leitor.nextLine();
        igual = cpf2.equals(c.cpf);
        System.out.println("Genero(m/f):");
        String genero2 = leitor.nextLine();
        igual = genero2.equals(c.genero);
        System.out.println("Endereço(bairro,rua,numero):");
        System.out.println("Bairro:");
        String bairro2 = leitor.next();
        System.out.println("Rua:");
        String rua2 = leitor.next();
        System.out.println("Número da casa");
        String numero_casa = leitor.next();
        igual = bairro2.equals(c.endereco[0]);
        igual = rua2.equals(c.endereco[1]);
        
        return igual;
        
    }
    
    
}
