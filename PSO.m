clc;clear;
tic;%�������м�ʱ
E0 = 0.001;%���
MaxNum = 100;%��������������
variableNum = 2; %������Ŀ
particleSize = 30;%����Ⱥ��ģ
c1 = 2; c2 = 2;%ѧϰ���Ӷ���Ϊ2
w = 0.6;%��������
vmax = 1; %�������ٶ�,ͨ��ѡȡΪ�仯��Χ��0.1-0.2
x = -5 + 10 * rand(particleSize,variableNum);%��ʼ���������ڵ�λ��
v = 2 * rand(particleSize,variableNum);
fitness = inline('sqrt(x(1).^2+x(2).^2)','x');
for i = 1:particleSize
    for j = 1:variableNum
        f(i) = fitness(x(i,:));
    end
end
personalbest_x = x; %�������ŵ�λ��
personalbest_y = f; %�������ŵ�ֵ
[globalbest_y i] = min(personalbest_y);%����personalbest_y����Сֵ��globalbest_y,i�Ǹ���Сֵ���ڵ�λ��
globalbest_x = personalbest_x(i,:);
k = 1; %��������
while k<=MaxNum
    for i = 1:particleSize
        for j = 1:variableNum
            f(i) = fitness(x(i,:));
        end
        if f(i)<personalbest_y(i) %�ж��Ƿ�ǰλ�õ�ֵС�ڵ�ǰ�����λ��(��Ϊ��ȡ����)
            personalbest_y(i) = f(i);
            personalbest_x(i,:) = x(i,:);
        end
    end
    [globalbest_y i] = min(personalbest_y);%����λ��
    globalbest_x = personalbest_x(i,:);%����λ��
    for i = 1:particleSize %���µ�ǰ��λ��
        v(i,:) = w*v(i,:)+c1*rand*(personalbest_x(i,:)-x(i,:))+c2*rand*(globalbest_x-x(i,:));
        for j = 1:variableNum
            if v(i,j)>vmax
                v(i,j) = vmax;
            elseif v(i,j) < -vmax
                v(i,j) = -vmax;
            end
        end
        x(i,:) = x(i,:) + v(i,:);
    end
%    if abs(globalbest_y)<E0,break,end 
    k = k+1;
end
Value1 = -globalbest_y; Value1 = num2str(Value1);
disp(strcat('the maximum value = ',Value1));
Value2 = globalbest_x; Value2 = num2str(Value2);
disp(strcat('the corresponding coordinate ','=',Value2))
t = -5:0.1:5;
[x,y] = meshgrid(t);
z = sqrt(x.^2+y.^2);
surf(x,y,z)
hold on;
plot(globalbest_x,-globalbest_y,'kp','linewidth',4);
legend('Ŀ�꺯��','�����������ֵ');xlabel('x');ylabel('y');grid on; toc;