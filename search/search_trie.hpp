#pragma once

#include "indexer/coding_params.hpp"

#include "coding/point_to_integer.hpp"

namespace search
{
static const uint8_t kCategoriesLang = 128;
static const uint8_t kPostcodesLang = 129;
static const uint8_t kPointCodingBits = 20;
}  // namespace search

namespace trie
{
inline serial::CodingParams GetCodingParams(serial::CodingParams const & orig)
{
  return serial::CodingParams(search::kPointCodingBits,
                              PointU2PointD(orig.GetBasePoint(), orig.GetCoordBits()));
}

}  // namespace trie
