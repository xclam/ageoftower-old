/**
 * Tower
 * 
 * Define the comportment of a Tower 
 * 
 * @author Romain Jolivot
 * @version 0.1
 */

package base;

public class Tower {

	private float _mRange;
	private float _mDamage;
	private float _mFireRate;
	
	// CONSTRUCTORS
	
	public Tower(){}
	
	public Tower(float range, float damage, float fireRate){
		this.set_mRange(range);
		this.set_mDamage(damage);
		this.set_mFireRate(fireRate);
	}

	// GETTER AND SETTER METHODS
	
	public float get_mRange() {
		return _mRange;
	}

	public void set_mRange(float _mRange) {
		this._mRange = _mRange;
	}

	public float get_mDamage() {
		return _mDamage;
	}

	public void set_mDamage(float _mDamage) {
		this._mDamage = _mDamage;
	}

	public float get_mFireRate() {
		return _mFireRate;
	}

	public void set_mFireRate(float _mFireRate) {
		this._mFireRate = _mFireRate;
	}
	
	// PUBLIC METHODS
	
}
