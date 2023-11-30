package visualização;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modificadores.Bugs;
import modificadores.Devs;
import planetas.Astros;
import posicionamento.Malha;
import posicionamento.Rodadas;

public class PainelMalha extends JPanel{
    static ArrayList<Celula> celulas = new ArrayList<>();
	JLabel campoImagem = new JLabel();
    ArrayList<Astros> planetasMortos = new ArrayList<>();
    Malha malha;
    
	public PainelMalha(Malha malha) {
		this.malha = malha;
		setLayout(new GridLayout(15,15));
		malha.adicionar_planetas();
		setBackground(Color.black);
		posicionarImagens();
	}
	
	public Celula criarCelula(ImageIcon imagem, int x, int y, int ordem) {
		Celula celula = new Celula(imagem,x,y,ordem);
		return celula;
	}
	
	public Astros verificPlanetas(int i, int j) {
        for (Astros planeta : Malha.planetas) {
            if (planeta.getY() == i && planeta.getX() == j) {
                return planeta;
            }
        }
        return null;
    }

	
	 public Devs verificDevs(int i, int j) {
	        for (Devs dev : Malha.devs) {
	            if (dev.getPosY() == i && dev.getPosX() == j) {
	            	return dev;
	            }
	        }
	        return null;
	        }

	 public Bugs verificBugs(int i, int j) {
	        for (Bugs bug : Malha.bugs) {
	            if (bug.getPosY() == i && bug.getPosX() == j) {
	            	return bug;
	        }
	    }
	        return null;
	 }
	 
	public void posicionarImagens() {
		    removeAll();
		    celulas.clear();
		    for (int i = 15; i > 0; i--) {
		        for (int j = 15; j > 0; j--) {
		            Celula celula;
		            int ordem = 0;
		            Astros planeta = verificPlanetas(i, j);
		            Bugs bug = verificBugs(i, j);
		            Devs dev = verificDevs(i, j);

		            if (planeta != null && planeta.isVivoMorto()==true) {
		                celula = criarCelula(planeta.getImagem(), planeta.getX(), planeta.getY(),ordem);
		            } 
		            else if(planeta != null && planeta.isVivoMorto()==false) {
		                celula = criarCelula(Rodadas.getImagem(), planeta.getX(), planeta.getY(),ordem);

		            }
		            else if (bug != null) {
		                celula = criarCelula(bug.getImagem(), bug.getPosX(), bug.getPosY(),ordem);
		            }
		            else if (dev != null) {
		                celula = criarCelula(dev.getImagem(), dev.getPosX(), dev.getPosY(),ordem);
		            }
		            else {
		                celula = criarCelula(null, j, i,ordem);
		            }
		            ordem++;
		            add(celula);
		            celulas.add(celula);
		        }
		    }

		    revalidate();
		    repaint();
		}
	
	public void modificar() {

		malha.plotarBugs();
		malha.plotarDevs();
		
		malha.iterar_planetas();
		posicionarImagens();
		
		malha.verificacaoBugColision();
		malha.verificacaoDevColision();
		
		alertaExplosao();
	}	
	
	public void adicionarCelula(ImageIcon imagem, int x, int y, int ordem) {
	    Celula celula = criarCelula(imagem, x, y, ordem);
	    add(celula);
	    celulas.add(celula);
	}

	public void alertaExplosao() {

        ArrayList<Astros> novosPlanetasMortos = new ArrayList<>();

        for (int i = 0; i < Malha.planetas.size(); i++) {
            Astros planeta = Malha.planetas.get(i);
            if (!planeta.isVivoMorto() && !planetaJaAdicionado(planetasMortos, planeta)) {
                novosPlanetasMortos.add(planeta);
            }
        }

        planetasMortos.addAll(novosPlanetasMortos);

		    
		    if (!novosPlanetasMortos.isEmpty()) {
		    	  try {
			            reproduzirSom("Icones/explosion.wav"); 
			        } catch (Exception e) {
			            e.printStackTrace();
			        }  
		    	JOptionPane.showMessageDialog(
		                null,
		                "O planeta "+novosPlanetasMortos.get(novosPlanetasMortos.size()-1).getNome()+" acabou de explodir!",
		                "Alerta de Explosão",
		                JOptionPane.WARNING_MESSAGE
		        );
		    }
}

    public static void reproduzirSom(String caminhoSom) throws Exception {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                PainelMalha.class.getResourceAsStream(caminhoSom)
        );
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }
    
    private static boolean planetaJaAdicionado(ArrayList<Astros> planetasMortos, Astros planeta) {
        for (Astros planetaMorto : planetasMortos) {
            if (planeta.equals(planetaMorto)) {
                return true; 
            }
        }
        return false;
    }
}
