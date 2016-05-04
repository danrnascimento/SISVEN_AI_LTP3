package cadastro;

/**Classe para objetos do tipo Cadastro, onde serão contidos, valores e métodos para o mesmo.

 * @author Daniel Nascimento

 */

import dados.*;
import erros.SisVendasException;
import java.util.*;

public class Cadastro {
	
	public static Map<String, dados.Cliente> clientes = new HashMap<String, dados.Cliente>();
	public static Map<Integer, dados.Produto> produtos = new HashMap<Integer, dados.Produto>();
	public static Map<Integer, dados.Venda> vendas = new HashMap<Integer, dados.Venda>();

	/**
	 * incluir cliente na lista
	 * @author Daniel Nascimento
	 * @param cliente Cliente - Objeto a ser incluso
	 */
	
	public static void incluirCliente(Cliente cliente){
		clientes.put(cliente.getCpf(), cliente);
	}
	
	/**
	 * remover cliente da lista de clientes
	 * @author Daniel Nascimento
	 * @param cliente Cliente - objeto a ser incluso
	 */

	public static void removerCliente(Cliente cliente){
		clientes.remove(cliente.getCpf());
	}
	
	/**
	 * procurar cliente pelo cpf
	 * @author Daniel Nascimento
	 * @param cpf String - Cpf a ser procurado 
	 * @throws SisVendasException
	 */
	
	public static Cliente procurarClienteCpf(String cpf) throws SisVendasException{
		
		if (clientes.containsKey(cpf)){
			return clientes.get(cpf);
		}else{
			throw new SisVendasException("Não encontrado");
		}
		
	}
	
	/**
	 * procurar pelo nome e organizar em ordem alfabetica
	 * @author Daniel Nascimento
	 * @param nome String - nome a ser procurado
	 * @throws SisVendasExceptions 
	 */
	
	public static ArrayList<Cliente> procurarClienteNome(String nome) throws SisVendasException{
		
		ArrayList<Cliente> listaAux = new ArrayList<Cliente>();
		
		for(Cliente auxiliar: clientes.values()){
			if(auxiliar.getNome().contains(nome)){
				listaAux.add(auxiliar);
			}	
		}
		
		if(listaAux.isEmpty()){
			throw new SisVendasException("Não existe cliente com este nome");
		}else{
			Collections.sort(listaAux, new Comparator<Cliente>() {
				
				@Override
				public int compare(Cliente auxiliar1, Cliente auxiliar2) {
					// TODO Auto-generated method stub
					return auxiliar1.getNome().compareTo(auxiliar2.getNome());
				}
				
			});
			
			return listaAux;
		}
		
	}
	
	/**
	 * incluir produto a lista de produtos
	 * @author Daniel Nascimento
	 * @param produto Produto - produto a ser incluido
	 */
	
	public static void incluirProduto(Produto produto){
		produtos.put(produto.getCodigo(), produto);
	}
	
	/**
	 * remover produto da lista de produtos
	 * @author Daniel Nascimeno
	 * @param produto Produto - produto a ser removido
	 */
	
	public static void removerProduto(Produto produto){
		produtos.remove(produto.getCodigo());
	}
	
	/**
	 * procurar produto na lista de produtos pelo codigo
	 * @author Daniel Nascimento
	 * @param cod Int - codigo a ser pesquisado
	 * @throws SisVendasException
	 */
	
	public static Produto procurarProdutoCod(int cod) throws SisVendasException{
		
		if (produtos.containsKey(cod)){
			return produtos.get(cod);
		}else{
			throw new SisVendasException("Não encontrado");
		}
		
	}
	
	/**
	 * procurar pelo nome do produto e exibir em ordem alfabetica
	 * @author Daniel Nascimento
	 * @param nome String - nome do produto a ser procurado
	 * @throws SisVendaException
	 */
	
	public static ArrayList<Produto> procurarProdutoNome(String nome) throws SisVendasException{
		
		ArrayList<Produto> listaAux = new ArrayList<Produto>();
		
		for(Produto auxiliar : produtos.values()){
			if(auxiliar.getNome().contains(nome)){
				listaAux.add(auxiliar);
			}
		}
		
		if(listaAux.isEmpty()){
			throw new SisVendasException("Não encontrdo");
		}else{
			Collections.sort(listaAux, new Comparator<Produto>() {
				
				@Override
				public int compare(Produto auxiliar1, Produto auxiliar2) {
					return auxiliar1.getNome().compareTo(auxiliar2.getNome());
				}
				
			});
			
			return listaAux;
		}
		
	}
	
	/**
	 * incluir venda na lista de vendas
	 * @author Daniel Nascimento
	 * @param venda Venda - venda a ser includia
	 */
	public static void incluirVenda(Venda venda){
		vendas.put(venda.getNumVenda(), venda);
	}
	
	
	/**
	 * remover venda da lista de vendas
	 * @author Daniel Nascimento
	 * @param venda Venda - venda a ser excluida
	 */
	
	public static void removerVenda(Venda venda){
		vendas.remove(venda.getNumVenda());
	}
	
	/**
	 * procurar venda na lista de vendas pelo codigo 
	 * @author Daniel Nascimento
	 * @param codigo int - codigo a ser procurado
	 * @return Venda - venda com o codigo procurado
	 * @throws SisVendaException
	 */
	
	public static Venda procurarVenda(int codigo) throws SisVendasException{
		if (vendas.containsKey(codigo)){
			return vendas.get(codigo);
		}else{
			throw new SisVendasException("Não encontrado!");
		}
	}
	
	/**
	 * procurar venda por cliente
	 * @author Daniel Nascimento
	 * @param cliente Cliente - cliente a ser procurado
	 * @return Lista ordenada das vendas que o cliente fez
	 * @throws SisVendasException
	 */
	
	public static ArrayList<Venda> procurarVendaCliente(Cliente cliente) throws SisVendasException{
		
		ArrayList<Venda> ListaAux = new ArrayList<Venda>();
		
		for(Venda auxiliar : vendas.values()){
			if(auxiliar.getCliente() == cliente){
				ListaAux.add(auxiliar);
			}
		}
		
		if(ListaAux.isEmpty()){
			throw new SisVendasException("Não encontrado");
		}else{
			Collections.sort(ListaAux, new Comparator<Venda>() {
				
				@Override
				public int compare(Venda auxiliar1, Venda auxiliar2) {
					// TODO Auto-generated method stub
					return auxiliar1.getCliente() == auxiliar2.getCliente() ? 1 : 0;
				}
				
			});
			
			return ListaAux;
		}
		
	}
	
	/**
	 * criar lista organizando por periodo ( pelo menos foi essa a intencao ) noobOn
	 * @author Daniel Nasciment
	 * @param dataInicio GregorianCalendar - data de inicio do periodo
	 * @param dataFinal GregorianCalendar - data final do periodo
	 * @return Lista desse periodo
	 * @throws SisVendaException
	 */
	
	public static ArrayList<Venda> procurarVendaPeriodo(GregorianCalendar dataInicio,GregorianCalendar dataFinal) throws SisVendasException{
		
		ArrayList<Venda> listAux = new ArrayList<Venda>();
		
		for(Venda auxliar : vendas.values()){
			if(auxliar.getDataVenda().get(GregorianCalendar.YEAR) >= dataInicio.get(GregorianCalendar.YEAR) &&
					auxliar.getDataVenda().get(GregorianCalendar.YEAR) <= dataFinal.get(GregorianCalendar.YEAR))
			{
				if(auxliar.getDataVenda().get(GregorianCalendar.MONTH) >= dataInicio.get(GregorianCalendar.MONTH) &&
						auxliar.getDataVenda().get(GregorianCalendar.MONTH) <= dataFinal.get(GregorianCalendar.MONTH))
				{
					if(auxliar.getDataVenda().get(GregorianCalendar.DAY_OF_MONTH) >= dataInicio.get(GregorianCalendar.DAY_OF_MONTH) &&
							auxliar.getDataVenda().get(GregorianCalendar.DAY_OF_MONTH) <= dataFinal.get(GregorianCalendar.DAY_OF_MONTH))
					{
						listAux.add(auxliar);
					}
				}
			}
		}
		
		if(listAux.isEmpty()){
			throw new SisVendasException("Não encontrado");
		}else{
			Collections.sort(listAux, new Comparator<Venda>() {

				@Override
				public int compare(Venda aux1, Venda aux2) {
					if (aux1.getDataVenda().get(GregorianCalendar.DAY_OF_MONTH) < 
					    aux2.getDataVenda().get(GregorianCalendar.DAY_OF_MONTH)) {
						return 1;	
					} 
					if (aux1.getDataVenda().get(GregorianCalendar.DAY_OF_MONTH) > 
				        aux2.getDataVenda().get(GregorianCalendar.DAY_OF_MONTH)) {
					    return -1;
					}
					return aux1.getDataVenda().compareTo(aux2.getDataVenda());
				}
			});
			
			return listAux;
		}
		
		
	}
	
	
}
