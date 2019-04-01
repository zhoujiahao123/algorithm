clc;clear;
tic;%程序运行计时
E0 = 0.001;%误差
MaxNum = 100;%粒子最大迭代次数
variableNum = 2; %变量数目
particleSize = 30;%粒子群规模
c1 = 2; c2 = 2;%学习因子都设为2
w = 0.6;%惯性因子
vmax = 1; %最大飞翔速度,通常选取为变化范围的0.1-0.2
x = -5 + 10 * rand(particleSize,variableNum);%初始化粒子所在的位置
v = 2 * rand(particleSize,variableNum);
fitness = inline('sqrt(x(1).^2+x(2).^2)','x');
for i = 1:particleSize
    for j = 1:variableNum
        f(i) = fitness(x(i,:));
    end
end
personalbest_x = x; %个体最优的位置
personalbest_y = f; %个体最优的值
[globalbest_y i] = min(personalbest_y);%返回personalbest_y的最小值给globalbest_y,i是该最小值存在的位置
globalbest_x = personalbest_x(i,:);
k = 1; %迭代次数
while k<=MaxNum
    for i = 1:particleSize
        for j = 1:variableNum
            f(i) = fitness(x(i,:));
        end
        if f(i)<personalbest_y(i) %判断是否当前位置的值小于当前的最佳位置(因为有取倒数)
            personalbest_y(i) = f(i);
            personalbest_x(i,:) = x(i,:);
        end
    end
    [globalbest_y i] = min(personalbest_y);%更新位置
    globalbest_x = personalbest_x(i,:);%更新位置
    for i = 1:particleSize %更新当前的位置
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
legend('目标函数','搜索到的最大值');xlabel('x');ylabel('y');grid on; toc;