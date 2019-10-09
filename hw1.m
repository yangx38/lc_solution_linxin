% Xiaotong Yang
% 1765014
% EE 440 HW1
% Oct 8, 2019

% 1. a in PDF
% 2. a 
pic = imread('1_4.bmp');
imshow(pic)

% 2. b
disp(class(pic));
max = max(pic(:)); % 255
min = min(pic(:)); % 0

% 2. c
double = double(pic);
imshow(double);

% 2. d 
imshow(double/255);


% 3.a
[X, map] = imread('1_2.tif', 'tif');
gray = rgb2gray(map);
imwrite(X, gray, 'Y.bmp');

% 3. b
Z0 = imrotate(X, 120);
imwrite(Z0, gray, 'Z0.bmp');

% 3. c
Z1 = imrotate(X, 10);
for c = 1 : 12
    Z1 = imrotate(Z1, 10);
end

% 3. d
% most of Z0 is still a flower part
% But Z1 shrinks the flower part into the center.

% 4. a
X = load('1_3.asc');
Y1 = X(1:4:384, 1:4:256);
imshow(Y1/256);

Y2 = zeros(96, 64);
for i = 1 : 96
    for j = 1 : 64 
        Y2(i, j) = mean2(X(i*4-3:i*4, j*4-3:j*4));
    end
end
imshow(Y2/256);

% 4. b Pixcel repeating
Y1_1 = zeros(384, 256);
for i = 1 : 384
    for j = 1 : 256
        Y1_1(i, j) = Y1(1+floor((i-1)/4, 1+floor((j-1)/4)));
    end
end
imshow(Y1_1/256)

% 4. b Bilinear interpolation
Y1_2 = zeros(384, 256);
for i = 1:4:384
    for j = 1:4:256
        Y1_2(i, j) = Y1(1+((i-1)/4), 1+((j-1)/4));
    end
end

for j = 1:4:256
    for i = 1:380
        if(mod(i-1, 4) ~= 0)
            P1 = floor((i-1)/4)*4+1;
            P2 = P1+4;
            Y1_2(i, j) = ((i-P1)*Y1_2(P2, j) + (P2-i)*Y1_2(P1, j))/4;
        end
    end
end

for i = 1:380
    for j = 1:252
        if(mod(j-1, 4))
            P1 = floor((j-1)/4)*4+1;
            P2 = P1+4;
            Y1_2(i, j) = ((j-P1)*Y1_2(i, P2) + (P2-j)*Y1_2(i, P1))/4;
        end
    end
end
imshow(Y1_2/256);

% comparison
% The pic done by pixel repeating method looks blocky, while the pic done by bilinear interpolation is much more smooth