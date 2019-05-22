package money;

public class Sum implements Expression{
    Expression augend;
    Expression addend;
    
    Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }
    
    public Expression times(int multiplier) {
        return new Sum(this.augend.times(multiplier), this.addend.times(multiplier));     
    }
    
    public Expression plus(Expression added) {
        return new Sum(this, this.addend);
    }
    
    public Money reduce(Bank bank, String to) {
        int amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }
}
