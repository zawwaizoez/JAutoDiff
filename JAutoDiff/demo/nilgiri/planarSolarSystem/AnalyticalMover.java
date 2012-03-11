package nilgiri.planarSolarSystem;

import nilgiri.math.RealNumber;
import nilgiri.math.autodiff.DifferentialFunction;
import nilgiri.math.autodiff.DifferentialVectorFunction;
import nilgiri.math.autodiff.Variable;


public class AnalyticalMover<R extends RealNumber<R>> extends AbstractMover<R>{

	protected DifferentialFunction<R> m_radius;
	protected DifferentialVectorFunction<R> m_position;
	protected DifferentialVectorFunction<R> m_velocity;
	protected DifferentialVectorFunction<R> m_accel;
	
	public AnalyticalMover(
			Variable<R> i_t,
			DifferentialFunction<R> i_radius,
			DifferentialVectorFunction<R> i_pos){//,
			//MoverDrawer<R> i_drawer){
		super(i_t);//, i_drawer);
		m_radius = i_radius;
		m_position = i_pos;
		m_velocity = m_position.diff(m_t);
		m_accel = m_velocity.diff(m_t);
	}

	@Override
	DifferentialFunction<R> radius() {
		return m_radius;
	}

	@Override
	DifferentialVectorFunction<R> position() {
		return m_position;
	}

	@Override
	DifferentialVectorFunction<R> velocity() {
		return m_velocity;
	}

	@Override
	DifferentialVectorFunction<R> accel() {
		return m_accel;
	}
	
}