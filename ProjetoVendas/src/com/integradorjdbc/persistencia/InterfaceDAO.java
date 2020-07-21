package com.integradorjdbc.persistencia;

import java.util.ArrayList;

public interface InterfaceDAO <Obj extends Object> {	
	public void cadastrar(Obj object);
	public void editar (Obj object);
	public void excluir (long id);
	public Obj buscarPorId (long id);
	public ArrayList<Obj> buscarTodos();

}
