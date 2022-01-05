package lambda.设计模式.结构形模式;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.Stream;

/**
 * @description: 装饰者模式
 * @author:maidang
 * @date:2022/01/06
 **/
public class Decorator {
	//本质是一系列流程的串行操作 oop模式就是将一些系列的行为封装到对象里面
	//计算费用的例子
	public static double generalTax(double salary) {
		return salary * 0.8;
	}

	public static double regionalTax(double salary) {
		return salary * 0.95;
	}

	public static double healthInsurance(double salary) {
		return salary - 200.0;
	}
	interface  SalaryCalculator{
		double calculate(double fee);
	}
	public class DefaultSalaryCalculator implements SalaryCalculator {
		@Override
		public double calculate(double grossAnnual) {
			return grossAnnual / 12;
		}
	}
	public abstract class AbstractTaxDecorator implements SalaryCalculator {
		private final SalaryCalculator salaryCalculator;

		public AbstractTaxDecorator( SalaryCalculator salaryCalculator ) {
			this.salaryCalculator = salaryCalculator;
		}
		protected abstract double applyTax(double salary);
		@Override
		public final double calculate(double gross) {
			double salary = salaryCalculator.calculate( gross );
			return applyTax( salary );
		}
	}
	public class GeneralTaxDecorator extends AbstractTaxDecorator {
		public GeneralTaxDecorator( SalaryCalculator salaryCalculator ) {
			super( salaryCalculator );
		}

		@Override
		protected double applyTax(double salary) {
			return generalTax( salary );
		}
	}

	public class RegionalTaxDecorator extends AbstractTaxDecorator {
		public RegionalTaxDecorator( SalaryCalculator salaryCalculator ) {
			super( salaryCalculator );
		}

		@Override
		protected double applyTax(double salary) {
			return regionalTax( salary );
		}
	}

	public class HealthInsuranceDecorator extends AbstractTaxDecorator {
		public HealthInsuranceDecorator( SalaryCalculator salaryCalculator ) {
			super( salaryCalculator );
		}

		@Override
		protected double applyTax(double salary) {
			return healthInsurance( salary );
		}
	}
	double netSalary = new HealthInsuranceDecorator(
		new RegionalTaxDecorator(
			new GeneralTaxDecorator(
				new DefaultSalaryCalculator()
			)
		)
	).calculate( 30000.00 );
	public class DefaultSalaryCalculator1 implements DoubleUnaryOperator {
		@Override
		public double applyAsDouble(double grossAnnual) {
			return grossAnnual / 12;
		}
	}
	double applyAsDouble = new DefaultSalaryCalculator1()
		.andThen( Decorator::generalTax )
		.andThen( Decorator::regionalTax )
		.andThen( Decorator::healthInsurance )
		.applyAsDouble( 30000.00 );

	public static double calculate(double gross, DoubleUnaryOperator... fs) {
		return Stream.of(fs )
			.reduce( DoubleUnaryOperator.identity(),
					 DoubleUnaryOperator::andThen )
			.applyAsDouble( gross );
	}

}
