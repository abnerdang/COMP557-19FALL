package comp557.a1;

import javax.vecmath.Tuple3d;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.gl2.GLUT;

import mintools.parameters.DoubleParameter;

public class RShoulderJoint extends DAGNode {

	DoubleParameter rx;
	DoubleParameter rz;
	DoubleParameter ry;
	Tuple3d position;
	
	// Constructor	
	public RShoulderJoint( String name ) {
		super(name);
		dofs.add( rx = new DoubleParameter( name+" rx", 0, -180, 180 ) );		
		dofs.add( rz = new DoubleParameter( name+" rz", 0, -180, 0 ) );
	}
	
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glPushMatrix();
		
		gl.glTranslated(position.x, position.y, position.z);
		gl.glRotated(rx.getValue(), 1, 0, 0);
		gl.glRotated(rz.getValue(), 0, 0, 1);
		
		
		//gl.glRotated(ry.getValue(), 0, 1, 0);
		
		super.display(drawable);
		gl.glPopMatrix();	
	}
	
	public void setPosition(Tuple3d t) {
		this.position = t;
	}

	
}
