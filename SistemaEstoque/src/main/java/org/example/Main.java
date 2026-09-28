package org.example;

import org.example.model.Estoque;
import org.example.model.Produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();

        int opcao;

        do{
            System.out.println("\n--- SISTEMA DE ESTOQUE --- \n1. Cadastrar Produto \n2. Listar Produtos \n3. Deletar Produto \n4. Atualizar Produto \n0. Sair \nEscolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if(opcao == 1){
                System.out.println("Digite o ID do produto: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Digite o nome do produto: ");
                String nome = scanner.nextLine();
                System.out.println("Digite a categoria do produto: ");
                String categoria = scanner.nextLine();
                System.out.println("Digite o valor do produto: ");
                double preco = scanner.nextDouble();
                System.out.println("Digite o quantidade do produto: ");
                int quantidadeEstoque = scanner.nextInt();
                scanner.nextLine();

                Produto novoProduto = new Produto(id, nome, categoria, preco, quantidadeEstoque);

                estoque.addProduto(novoProduto);

                System.out.println("Produto cadastrado com sucesso!");
            }
            else if(opcao == 2){
                estoque.ListarProdutos();
            }
            else if(opcao == 3){
                System.out.println("Digite o ID do produto: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                estoque.excluirProduto(id);
                System.out.println("Produto deletado com sucesso!");
            }
            else if(opcao == 4){
                System.out.println("Digite o ID do produto: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Produto produtoEncontrado = estoque.buscaID(id);

                if(produtoEncontrado != null){
                    System.out.println("O que deseja atualizar? \n1.Nome \n2.Categoria \n3.Preco \n4.Quantidade no estoque \n0.Sair \nEscolha uma opcao:");
                    opcao = scanner.nextInt();
                    scanner.nextLine();
                    if(opcao == 1){
                        System.out.println("Digite o novo nome: ");
                        String novoNome = scanner.nextLine();
                        produtoEncontrado.setNome(novoNome);
                        System.out.println("Nome atualizado com sucesso!");
                    }
                    else if(opcao == 2){
                        System.out.println("Digite a nova categoria: ");
                        String novaCategoria = scanner.nextLine();
                        produtoEncontrado.setCategoria(novaCategoria);
                        System.out.println("Categoria atualizado com sucesso!");
                    }
                    else if(opcao == 3){
                        System.out.println("Digite o novo preco: ");
                        double novoPreco = scanner.nextDouble();
                        produtoEncontrado.setPreco(novoPreco);
                        System.out.println("Preco atualizado com sucesso!");
                    }
                }

            }


        }while (opcao != 0);

    }
}