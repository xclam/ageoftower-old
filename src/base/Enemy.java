/**
 * Enemy
 * 
 * Define the comportment of an Enemy 
 * 
 * @author Romain Jolivot
 * @version 0.1
 */

package base;

public class Enemy {

	private float _mMaxLife;
	private float _mActualLfie;
	private float _mArmor;
	private float _mVelocity;
	private boolean _mFlying;	// 1 if the enemy is flying else 0
	
	// CONSTRUCTORS
	
	public Enemy() {}
	
	public Enemy(float life, float armor, float velocity, boolean flying){
		this.set_mMaxLife(life);
		this.set_mActualLfie(life);
		this.set_mArmor(armor);
		this.set_mVelocity(velocity);
		this.set_mFlying(flying);
	}

	// GETTER AND SETTER METHODS
	
	public float get_mMaxLife() {
		return _mMaxLife;
	}

	public void set_mMaxLife(float _mMaxLife) {
		this._mMaxLife = _mMaxLife;
	}

	public float get_mActualLfie() {
		return _mActualLfie;
	}

	public void set_mActualLfie(float _mActualLfie) {
		this._mActualLfie = _mActualLfie;
	}

	public float get_mArmor() {
		return _mArmor;
	}

	public void set_mArmor(float _mArmor) {
		this._mArmor = _mArmor;
	}

	public float get_mVelocity() {
		return _mVelocity;
	}

	public void set_mVelocity(float _mVelocity) {
		this._mVelocity = _mVelocity;
	}

	public boolean is_mFlying() {
		return _mFlying;
	}

	public void set_mFlying(boolean _mFlying) {
		this._mFlying = _mFlying;
	}	
	
	// PUBLIC METHODS
	
	/**
	 * Decrement the enemy life.
	 * @param 	damage	the value to decrement
	 * @return 			is the enemy still alive
	 */
	public boolean takeDamage(float damage){
		this._mActualLfie = this._mActualLfie - (damage - this._mArmor);
		if (this._mActualLfie <= 0) {
			return false;
		}else
			return true;
	}
	
	
}
