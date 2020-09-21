package br.edu.uepb;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TurmaRepository  {


    // simulando nossa base de dados
    private static HashMap<Integer, Turma> turmas = new HashMap<>();

    // métodos para manipular
    public List<Turma> getAll() {
        return new ArrayList<Turma>(turmas.values());
    }

    public void create(final Turma p) {
        if (p.getId() == 0)
            p.setId(generateId(turmas.size() + 1));
        turmas.put(turmas.getId(), p);
    }

    private int generateId(final int possible) {
        if (turmas.containsKey(possible))
            return generateId(possible + 1);
        return possible;
    }

    public Turma getById(final int id) {
        return turmas.get(id);
    }

    public void edit(final Turma p) {
        turmas.remove(p.getId());
        turmas.put(p.getId(), p);
    }

    public void delete(final int id) {
        turmas.remove(id);
    }
}