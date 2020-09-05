package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		List<Funcionario> list = new ArrayList<>();

		System.out.println("Quntos funcionarios vao ser registrados ?");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Funcionario " + (i + 1) + " :");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.println("Id ja existe : Tnete novamente ");
				id = sc.nextInt();
			}
			System.out.print("Nome : ");
			sc.nextLine();
			String nome = sc.nextLine();
			while (nomeTem(list, nome)) {
				System.out.println("Este nome ja existe : tente novamente ");
				nome = sc.nextLine();
			}
			System.out.print("Salario: ");
			Double salario = sc.nextDouble();

			Funcionario fun = new Funcionario(id, nome, salario);
//			Colocar dentro da lista
			list.add(fun);

		}

		System.out.println("Entre com o Id do funcionario que deseja aumentar ");
		int idSalario = sc.nextInt();
//		Procurando a posicao do idSalario
		Funcionario fun = list.stream().filter(x -> x.getId() == idSalario).findFirst().orElse(null);

//		Integer posId = temId(list, idSalario);
		if (fun == null) {
			System.out.println("Esse id nao existe");
		} else {
			System.out.println("Entre com a procentagem");
			double procento = sc.nextDouble();
			fun.aumentarSalario(procento);
		}
		
		System.out.println();
		System.out.println("Lista de empregados ");
		for (Funcionario funs : list) {
			System.out.println(funs);
		}
		sc.close();
	}

	public static Integer temId(List<Funcionario> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}

	public static boolean hasId(List<Funcionario> list, int id) {
		Funcionario fun = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return fun != null;
	}

	public static boolean nomeTem(List<Funcionario> list, String nome) {
		Funcionario fun = list.stream().filter(x -> x.getNome() == nome).findFirst().orElse(null);
		return fun != null;
	}

}
