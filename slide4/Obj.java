package slide4;


class Obj // Contém dados do objeto 3D
{ float rho, theta=0.3F, phi=1.3F, d, objSize,
		v11, v12, v13, v21, v22, v23, v32, v33, v43; // Elementos da matriz de visualização V 
Point3D[] w;	// Coordenadas do mundo 
Point2D[] vScr; // Coordenadas de tela 
Obj()   
{ w = new Point3D[8];
  vScr = new Point2D[8]; 
  // Superfície da base: 
  w[0] = new Point3D( 1,-1, -1);
  w[1] = new Point3D( 1, 1, -1);
  w[2] = new Point3D(-1, 1, -1);
  w[3] = new Point3D(-1,-1, -1);
  // Superfície do topo: 
  w[4] = new Point3D( 1,-1, 1);
  w[5] = new Point3D( 1, 1, 1);
  w[6] = new Point3D(-1, 1, 1);
  w[7] = new Point3D(-1,-1, 1); 
  objSize = (float)Math.sqrt (12F);
		// = sqrt(2 * 2 + 2 * 2 + 2 * 2)
		// = distância entre dois vértices opostos 
  rho = 5 * objSize;  // Para razoável efeito de perspectiva
		
		}

void initPersp() 
{ float costh = (float)Math.cos(theta),
		sinth = (float)Math.sin(theta), 
		cosph = (float)Math.cos(phi),
		sinph = (float)Math.sin(phi);
  v11 = -sinth;  v12 = -cosph * costh; v13 = sinph * costh;
 v21 = costh; v22 = -cosph * sinth; v23 = sinph * sinth;
               v32 = sinph;          v33 = cosph;
                                     v43 = -rho;

}       
//código utilizados na etapa de transformação de visualização e perspectiva
void eyeAndScreen() 
{ initPersp();
for (int i=0; i<8; i++)
{ Point3D p = w[i];
float x = v11 * p.x + v21 * p.y,
      y = v12 * p.x + v22 * p.y + v32 * p.z,
      z = v13 * p.x + v23 * p.y + v33 * p.z + v43;
vScr[i] = new Point2D(-d * x/z, -d * y/z);

}

}

}
   

 
  

