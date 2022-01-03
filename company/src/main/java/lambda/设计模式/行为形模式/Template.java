package lambda.设计模式.行为形模式;

import java.util.function.Consumer;

/**
 * @description: 模板模式 模板设计模式
 * @author:maidang
 * @date:2022/01/03
 **/
public class Template {
	//资源使用的场景
	public class Resource{
		String fileName;
		public void closeFile(){

		}
		public void openFile(){

		}
	}

	//Traditional Design patterns
	public void main1() {
		resourceTemplate simpleResource = new simpleResourceTemplate();
		simpleResource.resourceStream();
	}

	//Function Design patterns
	public void main2() {
		functionTemplate functionTemplate = new functionTemplate();
		Resource resource = new Resource();
		functionTemplate.resourceStream(resource, resource1 -> System.out.println("open Resource"),
										resource1 -> System.out.println("handle Resource"),
										resource1 -> System.out.println("close Resource"));
	}

	//abstract template, define all kind of function and template
	public abstract class resourceTemplate{
		public abstract void openResource();
		public abstract void handleResource();
		public abstract void closeResource();
		public void resourceStream(){
			try {
				openResource();
				handleResource();
			}finally {
				closeResource();
			}
		}
	}

	public class simpleResourceTemplate extends resourceTemplate{

		Resource resource = new Resource();
		@Override
		public void openResource() {
			resource.openFile();
		}

		@Override
		public void handleResource() {
			//doing  specific logic
		}

		@Override
		public void closeResource() {
			resource.closeFile();
		}
	}



	//function template
	public class functionTemplate{
		//public abstract void openResource();
		//public abstract void handleResource();
		//public abstract void closeResource();

		//define argument absolutely depending on you
		public void resourceStream(Resource resource,Consumer<Resource> s,Consumer<Resource> u,Consumer<Resource> v){
			try {
				s.accept(resource);
				u.accept(resource);
			}finally {
				v.accept(resource);
			}
		}
	}

}
