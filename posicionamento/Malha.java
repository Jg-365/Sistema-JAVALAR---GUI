package posicionamento;
import java.util.ArrayList;
import java.util.Random;

import modificadores.Bugs;
import modificadores.Devs;
import planetas.Astros;
import planetas.C;
import planetas.C_sharp;
import planetas.Cplusplus;
import planetas.Java;
import planetas.Javascript;
import planetas.Php;
import planetas.Python;
import planetas.Ruby_on_Rails;

public class Malha {
	
	Python python = new Python();
	Javascript javascript = new Javascript();
	Ruby_on_Rails ruby = new Ruby_on_Rails();
	Php php = new Php();
	C_sharp c_sharp = new C_sharp();
	Cplusplus cplusplus = new Cplusplus();
	C c = new C();
	Java java = new Java();
	Random sorteio = new Random();
	
	public static ArrayList<Astros> planetas = new ArrayList<>();
	public static ArrayList<Bugs> bugs = new ArrayList<>();
	public static ArrayList<Devs> devs = new ArrayList<>();
	
 	public Malha() {
	}
	
	public void adicionar_planetas() {
		planetas.add(java);
	    planetas.add(python);
		planetas.add(javascript);
		planetas.add(ruby);
		planetas.add(php);
		planetas.add(c_sharp);
		planetas.add(cplusplus);
		planetas.add(c);
	}

	public void adicionarBugs(Bugs bug) {
		bugs.add(bug);
	}
	
	public void adicionarDevs(Devs dev) {
		devs.add(dev);
	}
	
	public Devs criarDevs() {
    	ArrayList<Devs> copiaDevs = new ArrayList<>(devs);
    	ArrayList<Bugs> copiaBugs = new ArrayList<>(bugs);

		int posX, posY;

        do {
            posX = sorteio.nextInt(15)+1;
            posY = sorteio.nextInt(15)+1;
        } while ((posX == 8) && (posY == 8) ||posX==0 || posY == 0);
        
        for (Devs dev : copiaDevs) {
            if (dev.getAtivoInativo() == true && (dev.getPosX() == posX && dev.getPosY() == posY)) {
               devs.remove(dev); 
            }
        }
        for(Bugs bug : copiaBugs) {
            if (bug.getAtivoInativo() == true && (bug.getPosX() == posX && bug.getPosY() == posY)) {
            	bugs.remove(bug);
            }
        }
        return new Devs(posX, posY);
    }

    public Bugs criarBugs() {
    	ArrayList<Devs> copiaDevs = new ArrayList<>(devs);
    	ArrayList<Bugs> copiaBugs = new ArrayList<>(bugs);
    	int posX, posY;

        do {
            posX = sorteio.nextInt(15)+1;
            posY = sorteio.nextInt(15)+1;
        } while ((posX == 8) && (posY == 8) ||posX==0 || posY == 0);
        
        for (Devs dev : copiaDevs) {
            if (dev.getAtivoInativo() == true && (dev.getPosX() == posX && dev.getPosY() == posY)) {
               devs.remove(dev); 
            }
        }
        for(Bugs bug : copiaBugs) {
            if (bug.getAtivoInativo() == true && (bug.getPosX() == posX && bug.getPosY() == posY)) {
            	bugs.remove(bug);
            }
        }
        return new Bugs(posX, posY);
    }

   
	public void plotarBugs() {
        if (Rodadas.getNumeroDeBugs() != 0) {
            for (int i = 0; i < Rodadas.getNumeroDeBugs(); i++) {
            	adicionarBugs(criarBugs());
            }
        }
    }

    public void plotarDevs() {
        if (Rodadas.getNumeroDeDevs() != 0) {
            for (int i = 0; i < Rodadas.getNumeroDeDevs(); i++) {
                adicionarDevs(criarDevs());
            }
        }
    }

    public void verificacaoBugColision() {
        ArrayList<Bugs> copiaBugs = new ArrayList<>(bugs);
        
    	for (Bugs bug : copiaBugs) {
            if (bug.getAtivoInativo()) {
                for (Astros planeta : planetas) {
                    if (planeta.isVivoMorto() && (bug.getPosX() == planeta.getX()) && (bug.getPosY() == planeta.getY())) {
                        planeta.desacelerar();
                        planeta.setBugsColididos(planeta.getBugsColididos()+1);
                        bug.setAtivoInativo(false);
                        bugs.remove(bug);
                        if (planeta.getVelocidadeTranslacao() == 0) {
                            planeta.setVivoMorto(false);
                            planeta.setHrsPorInstante(0);
                            Rodadas.setNumeroPlanetasMortos(Rodadas.getNumeroPlanetasMortos()+1);
                        }
                    }
                }
            }
        }
    }

    public void verificacaoDevColision() {
        ArrayList<Devs> copiaDevs = new ArrayList<>(devs);
        
    	for (Devs dev : copiaDevs) {
            if (dev.getAtivoInativo()) {
                for (Astros planeta : planetas) {
                    if (planeta.isVivoMorto() && (dev.getPosX() == planeta.getX()) && (dev.getPosY() == planeta.getY())) {
                        planeta.acelerar();
                        planeta.setDevsColididos(planeta.getDevsColididos()+1);
                        dev.setAtivoInativo(false);
                        devs.remove(dev);
                    }
                }
            }
        }
    }
	
    public void iterar_planetas() {
        for (int i = 0; i < planetas.size(); i++) {
            int deslocamento = planetas.get(i).mover(planetas.get(i).getVelocidadeTranslacao());
            planetas.get(i).setDeslocamentoTotal(planetas.get(i).getDeslocamentoTotal() + deslocamento);
            for (int j = 0; j < deslocamento; j++) {
                int nova_x = planetas.get(i).getX();
                int nova_y = planetas.get(i).getY();

                if (nova_x == planetas.get(i).getMaxX() && nova_y > planetas.get(i).getMinY()) {
                    nova_y--;
                } else if (nova_y == planetas.get(i).getMinY() && nova_x > planetas.get(i).getMinX()) {
                    nova_x--;
                } else if (nova_x == planetas.get(i).getMinX() && nova_y < planetas.get(i).getMaxY()) {
                    nova_y++;
                } else if (nova_y == planetas.get(i).getMaxY() && nova_x < planetas.get(i).getMaxX()) {
                    nova_x++;
                }
                
                planetas.get(i).setX(nova_x);
                planetas.get(i).setY(nova_y);
                planetas.get(i).setDeslocamento(deslocamento);
            }
        }
    }   
	
	public static void norte_sul() {
		System.out.println("\n\n");
		for(int i = 1; i < 7;i++) {
		int y_atual = planetas.get(i).getY();
			if(y_atual>8) {
				System.out.println(planetas.get(i).getNome() + " está acima de Java");
			}
			else if(y_atual == 8) {
				System.out.println(planetas.get(i).getNome() + " está na linha de Java");
			}
			else {
				System.out.println(planetas.get(i).getNome() + " está abaixo de Java");
			}
	     }
      }
    }
