package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CarregarDados {

	public int[][] carregarMatriz(int tamanhoX, int tamanhoY, String diretorio)
			throws IOException {

		int matz[][] = new int[tamanhoY][tamanhoX];
		ArrayList<String> arqText = new ArrayList<String>();
		String linha = "";
		InputStream is = getClass().getClassLoader().getResourceAsStream(diretorio);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		while ((linha = br.readLine()) != null)
			arqText.add(linha);

		int j = 0;
		for (int i = 0; i < arqText.size(); i++) {
			StringTokenizer tokens = new StringTokenizer(arqText.get(i), ",");
			while (tokens.hasMoreElements()) {
				matz[i][j] = Integer.parseInt((String) tokens.nextElement());
				j++;
			}
			j = 0;
		}
		return matz;
	}

	public Personagem carregaPersonagem() {
		return null;
	}
}
