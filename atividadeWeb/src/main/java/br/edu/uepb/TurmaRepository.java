package br.edu.uepb;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TurmaRepository  {


    // simulando nossa base de dados
    private static HashMap<Integer, Turma> turmas = new HashMap<>();
    Turma turma = new Turma();

    // métodos para manipular
    public List<Turma> getAll() {
        return new ArrayList<>(turmas.values());
    }

    public void create(final Turma turma) {
        if (turma.getId() == 0)
            turma.setId(generateId(turmas.size() + 1));
        turmas.put(turma.getId(), turma);
    }

    private int generateId(final int possible) {
        if (turmas.containsKey(possible))
            return generateId(possible + 1);
        return possible;
    }

    public Turma getById(final int id) {
        return turmas.get(id);
    }

    public void edit(final Turma turma) {
        turmas.remove(turma.getId());
        turmas.put(turma.getId(), turma);
    }

    public void delete(final int id) {
        turmas.remove(id);
    }
}