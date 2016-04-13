# C++
[gcc��ʷ�汾Դ����](ftp://ftp.gnu.org/pub/gnu/gcc/)

## c++ģ��
	1.����ģ��
	��ʽ��template <typename T, typename B...>
	      void fn(T a, B b)
	      {
	      	...
	      }

	����ʱ��
		int a;
		float b;
		fn(a, b); //ʵ�����ݣ�����ʹ��fn(int, float)

	2.��ģ��
	��ʽ��template<typename T1, typename T2...> class className{}
		eg: className<int, float> a or ::fn(){}
	      template<typename T>
	      class A
	      {
	      	public:
			T a;
			T b;
			T fn(T c, T d);
	      }
	      A<int> object; //����ʹ�� A(2) object
		  
##����
	1.inline ���� 
	ʵ�ָ�Ч��
	
##��	(������Ԥ�������)
	1.�곣��	���ַ��滻
	2.�꺯��
	
���ԭ�򣬾�����ʹ�ú꣬ʹ��ģ��ķ��ͺ������ĸ�Ч�����ʵ��

	�꺯����
	#define SUM(a, b) ((a) + (b))
	
	ģ��+������
	template<typename T>
	inline T sum(const T &a, const T &b){
		return (a + b);
	}
	
#### ����ʹ�ú�ĵط�
	
	1.�ַ�����
		
		�ַ�����������#	
		#parameter	--> "parameter"
		�ܹ��ַ����������ı����Ǻ�����������������ĳ���Ӵ���token�����е�
			
			#define STRING(str) #str // "str"  (�����Ǻ꺯���еĲ������ſ����ַ�����)
		
		�궨���е����ӷ�##
		���ӷ�##����������token����Ϊһ��token������������λ�ڵ�һ��token֮ǰor���һ��token֮��
		ע���������ӵĶ���ֻҪ��token���У�����һ���Ǻ����,����##�ֱ���λ�ں궨���в���Ч������Ϊ�����ڸ��
		
			#define LINK(a, b) __##a##__##b##__	// __a__b__
		
	
	2.linux�ں˵�����ʵ�� list_entry
		
		#define list_entry(ptr, type, member) ((type *)((char *)(ptr) - (unsigned long)(&((type *)0)->member)))	// 0(NULL)
		ʹ��list_entry()�꣬��linux�����з�����������
		
		ԭ��ָ��ptrָ��ṹ��type�еĳ�Աmember��ͨ��ָ��ptr�����ؽṹ��type��ʼ��ַ
			(unsigned long)(&((type *)0)->member) ��0��ַת��Ϊtype�ṹ��ָ�룬Ȼ���ȡ�ṹ��member��Աָ�룬
			������ǿ��ת��Ϊunsigned long ����
			
	**���Ա����ָ�����֪ʶ��**
	������Ա������û�з�����ĳ�Ա���ݣ�����ʹ��NULLָ���ȡ���Ա����ָ�� ((type *)NULL)->fun()
		���������⣬NULLָ�룬���ܷ������Ա���� (*thisָ��)
	������ʳ�Ա����ָ�� obj.(*fun)()
	�������ʳ�Ա����ָ�� &OBJ::fun	(��ͨ����ָ�벻ͬ������ȡ��ַ)
	
	
	3.��������ִ��ĳЩ����ʱ���ܻ�ʧ�ܣ���ʱҪ��ӡ��ʧ�ܵĴ���λ�ã�ֻ��ʹ�ú�ʵ�֡� 
		
		#define SHOW_CODE_LOCATION() cout << __FILE__ << ':' << __LINE__ << endl
		// ����
		if (error){
			SHOW_CODE_LOCATION();
		}
	